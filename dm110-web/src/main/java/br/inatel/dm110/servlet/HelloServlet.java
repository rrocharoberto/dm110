package br.inatel.dm110.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -24118939727042992L;

	@Inject
	Logger log;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		log.info("Running doGet with name: " + name);

		if (name != null) {
			log.info("name: " + name);
			req.setAttribute("name", name); // atributo para usar na página de resposta
			req.setAttribute("greetings", "Hi!");
		} else {
			HttpSession session = req.getSession();
			Object nameSaved = session.getAttribute("nameSaved");
			if (nameSaved != null) {
				log.info("nameSaved: " + nameSaved);
				req.setAttribute("previousName", nameSaved);
				req.setAttribute("greetings", "Hello!");
			}
		}
		req.setAttribute("currentDate", new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new java.util.Date()));
		forwardResponse("/hello_get_result.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		log.info("Running doPost with nameSaved: " + name);

		req.setAttribute("nameSaved", name); // usado na página JSP

		HttpSession session = req.getSession();
		session.setAttribute("nameSaved", name); //stateful: will be used in next servlet call

		forwardResponse("/hello_post_result.jsp", req, resp);
	}

	private void forwardResponse(String path, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher disp = context.getRequestDispatcher(path);
		disp.forward(req, resp); // direciona para uma página JSP.
	}
}
