package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import br.inatel.dm110.api.example.HelloInterface;
import br.inatel.dm110.api.example.MessageTO;
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
	
	@Override
	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String status() {
		log.info("Status endpoint called.");
		return "Status ok.";
	}

	@Override
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageTO sayHello(@PathParam("name") String name) {
		log.info("Saying hello to: " + name);

		MessageTO msg = new MessageTO(name, "");
		msg.setMessage("Hello " + name + "!");
		return msg;
	}
}
