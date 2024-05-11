package br.inatel.dm110.impl.example;

import java.util.Collection;
import java.util.logging.Logger;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.inatel.dm110.api.example.MessageInterface;
import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.impl.example.support.MessageException;

@RequestScoped
@Path("/message")
public class MessageResource implements MessageInterface {

	@Inject
	Logger log;
	
	private MessageMemoryDAO dao = new MessageMemoryDAO(); // in memory cache

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<MessageTO> getAllMessages() {
		log.info("Retrieving all messages.");
		return dao.getMessages();
	}
	
	@Override
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MessageTO getMessage(@PathParam("id") Integer id) {
		log.info("Retrieving message with id: " + id);
		MessageTO msg = dao.getMessage(id);
		if (msg == null) {
			throw new MessageException("Message not found with id: " + id);
		}
		return msg;
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public int storeNewMessage(MessageTO message) {
		log.info("Storing message: " + message);
		int id = dao.storeNewMessage(message);
		return id;
	}

	@Override
	// Example of receiving the post call from a web form
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public MessageTO postMessage(@FormParam("first") String first, @FormParam("last") String last) {
		log.info("Storing form message: " + first + " " + last);
		MessageTO message = new MessageTO();
		message.setFirstName(first);
		message.setLastName(last);
		int id = dao.storeNewMessage(message);
		return message;
	}
}
