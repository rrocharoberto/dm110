package br.inatel.dm110.api.example;

import java.util.Collection;

import jakarta.ws.rs.core.Response;

public interface MessageInterface {

	MessageTO getMessage(Integer id);

	int storeNewMessage(MessageTO message);

	Collection<MessageTO> getAllMessages();

	// Example of receiving the post call from a web form
	MessageTO postMessage(String first, String last);
}
