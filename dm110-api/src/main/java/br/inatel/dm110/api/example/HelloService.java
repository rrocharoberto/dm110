package br.inatel.dm110.api.example;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public interface HelloService {

	@GET
	@Path("/status/{name}")
	@Produces(MediaType.TEXT_HTML)
	String sayHello(@PathParam("name") String name);

	@GET
	@Path("/message/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Response getMessage(@PathParam("id") Integer id);

	@POST
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response storeNewMessage(MessageTO message);

	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	Response getAllMessages();

	// Example of receiving the post call from a web form
	@POST
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	MessageTO postMessage(@FormParam("first") String first, @FormParam("last") String last);
}
