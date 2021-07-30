package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.example.HelloService;
import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.interfaces.example.HelloRemote;

@RequestScoped
public class HelloServiceImpl implements HelloService {

	// in memory cache
	private HelloMemoryDAO dao = new HelloMemoryDAO();
	
	private static Logger log = Logger.getLogger(HelloServiceImpl.class.getName());

	@EJB(lookup="ejb:dm110-ear-1.0/dm110-ejb-1.0/HelloBean!br.inatel.dm110.hello.interfaces.HelloRemote")
	private HelloRemote helloBean;


	@Override
	public String sayHello(String name) {
		log.info("name: " + name);
		String message = helloBean.sayHello(name);
		return "Status ok. Hello " + message;
	}

	@Override
	public Response getMessage(Integer id) {
		log.info("retrieving message: " + id);
		MessageTO msg = dao.getMessage(id);
		if (msg != null) {
			return Response.ok(msg).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response storeNewMessage(MessageTO message) {
		log.info("storing message: " + message);
		int id = dao.storeNewMessage(message);
		return Response.ok(String.valueOf(id)).build();
	}

	@Override
	public Response getAllMessages() {
		log.info("retrieving all messages.");
		return Response.ok(dao.getMessages()).build();
	}
}
