package br.inatel.dm110.interfaces.example;

import java.util.List;

import br.inatel.dm110.api.example.MessageTO;

public interface Hello {

	String sayHello(String name);
	
	MessageTO getMessage(Integer id);
	
	int storeNewMessage(MessageTO message);
	
	List<MessageTO> getAllMessages();
}
