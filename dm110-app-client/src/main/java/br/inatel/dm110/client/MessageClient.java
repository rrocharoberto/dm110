package br.inatel.dm110.client;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.inatel.dm110.api.example.MessageTO;

public class MessageClient {

	private static final String REST_BASE_URI = "http://localhost:8080/dm110-web/api/message";

	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		System.out.println("Message service:");
		
		MessageTO msg = new MessageTO("Roberto", "Rocha");
		System.out.println("Result from POST: " + createMessage(msg));

		System.out.println("Result from GET: " + getMessage(0));
		System.out.println("Result from GET (non existing object): " + getMessage(100));

		System.out.println("Result from getAllMessages(): ");
		getAllMessages().stream().forEach(System.out::println);
	}

	public static MessageTO getMessage(Integer id) {
		return client
			.target(REST_BASE_URI)
			.path(String.valueOf(id))
			.request(MediaType.APPLICATION_JSON)
			.get(MessageTO.class);
	}
	
	public static Response createMessage(MessageTO msg) {
		return client
			.target(REST_BASE_URI)
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(msg, MediaType.APPLICATION_JSON));
	}

	public static List<MessageTO> getAllMessages() {
		List<MessageTO> list = client
			.target(REST_BASE_URI)
			.request(MediaType.APPLICATION_JSON)
			.get(Response.class)
			.readEntity(new GenericType<List<MessageTO>>() {});
		return list;
	}
}
