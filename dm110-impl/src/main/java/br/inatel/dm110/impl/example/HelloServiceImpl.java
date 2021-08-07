package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.example.HelloService;
import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.interfaces.example.HelloLocal;

@RequestScoped
public class HelloServiceImpl implements HelloService {

	private static Logger log = Logger.getLogger(HelloServiceImpl.class.getName());
	
	@EJB
	private HelloLocal helloBean;

	@Override
	public String sayHello(String name) {
		log.info("name: " + name);
		//return "Status ok. Hello " + name + " from Rest Service.";
		return "Status ok. " + helloBean.sayHello(name);
	}

	@Override
	public Response getMessage(Integer id) {
		log.info("retrieving message: " + id);
		MessageTO msg = helloBean.getMessage(id);
		if (msg != null) {
			return Response.ok(msg).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response storeNewMessage(MessageTO message) {
		log.info("storing message: " + message);
		int id = helloBean.storeNewMessage(message);
		return Response.ok(String.valueOf(id)).build();
	}

	@Override
	public Response getAllMessages() {
		log.info("retrieving all messages.");
		return Response.ok(helloBean.getAllMessages()).build();
	}

//	@Override
//	public MessageTO postMessage(String first, String last) {
//		log.info("Saving message from the form.");
//		MessageTO msg = dao.createMessage(first, last);
//		dao.storeNewMessage(msg);
//		return msg;
//	}
}
