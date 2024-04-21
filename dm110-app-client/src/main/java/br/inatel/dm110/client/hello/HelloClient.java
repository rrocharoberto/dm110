package br.inatel.dm110.client.hello;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import br.inatel.dm110.api.example.MessageTO;

public class HelloClient {

	private static final String REST_BASE_URI = "http://localhost:8080/dm110-web/api/hello";
	private static final String REST_URI_GET = REST_BASE_URI + "/message";
	private static final String REST_URI_POST = REST_URI_GET;
	private static final String REST_URI_GET_ALL = REST_BASE_URI + "/messages";

	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) {
		System.out.println("Message service:");
		
		MessageTO msg = new MessageTO();
		msg.setFirstName("Roberto");
		msg.setLastName("Rocha");
		System.out.println("Result from POST: " + createMessage(msg));

		System.out.println("Result from GET 1: " + getMessage(1));
		System.out.println("Result from GET 2: " + getMessage(2));
		
		System.out.println("Result from getAllMessages(): ");
		getAllMessages().stream().forEach((m) -> System.out.println(m));
	}

	public static MessageTO getMessage(Integer id) {
		return client
			.target(REST_URI_GET)
			.path(String.valueOf(id))
			.request(MediaType.APPLICATION_JSON)
			.get(MessageTO.class);
	}
	
	public static Response createMessage(MessageTO msg) {
	    return client
	      .target(REST_URI_POST)
	      .request(MediaType.APPLICATION_JSON)
	      .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
	}

	public static List<MessageTO> getAllMessages() {
		List<MessageTO> list = client
            .target(REST_URI_GET_ALL)
            .request(MediaType.APPLICATION_JSON)
            .get(Response.class)
            .readEntity(new GenericType<List<MessageTO>>() {});
		return list;
	}
}
