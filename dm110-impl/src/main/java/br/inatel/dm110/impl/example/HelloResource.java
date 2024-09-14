package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import br.inatel.dm110.api.example.HelloInterface;
import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.interfaces.example.HelloLocal;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/hello")
public class HelloResource implements HelloInterface {

	@Inject
	Logger log;

	@EJB
	private HelloLocal helloBean;

	@Override
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String status() {
		log.info("Status endpoint called.");
		return helloBean.status();
	}

	@Override
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageTO sayHello(@PathParam("name") String name) {
		log.info("Saying hello to: " + name);
		return helloBean.sayHello(name);
	}
}
