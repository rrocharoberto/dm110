package br.inatel.dm110.api.example;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.MessageTO;

@Path("/hello")
public interface HelloService {

	@GET
	@Path("/say/{name}")
	@Produces(MediaType.TEXT_HTML)
	String sayHello(@PathParam("name") String name);

	@GET
	@Path("/message/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Response getMessage(@PathParam("id") Integer id);

	@POST
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	MessageTO postMessage(@FormParam("first") String first, @FormParam("last") String last);

	@POST
	@Path("/storeMessage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	int storeNewMessage(MessageTO message);

	@GET
	@Path("/messageList")
	@Produces(MediaType.APPLICATION_JSON)
	Collection<MessageTO> getMessages();

}
