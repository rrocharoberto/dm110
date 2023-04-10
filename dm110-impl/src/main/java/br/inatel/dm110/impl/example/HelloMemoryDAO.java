package br.inatel.dm110.impl.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.inatel.dm110.api.example.MessageTO;

public class HelloMemoryDAO {

	private static int count = 0;

	// only for testing: in memory storage
	private static Map<Integer, MessageTO> cache = new HashMap<>();

	public MessageTO getMessage(Integer id) {
		return cache.get(id);
	}

	public int storeNewMessage(MessageTO message) {
		message.setMessage("Hello " + message.getFirstName() + " " + message.getLastName());
		int id = count;
		cache.put(id, message);
		count++;
		return id;
	}

	public List<MessageTO> getMessages() {
		return cache.values().stream().collect(Collectors.toList());
	}

	public MessageTO createMessage(String first, String last) {
		MessageTO result = new MessageTO();
		result.setFirstName(first);
		result.setLastName(last);
		String message = String.format("Hello %s %s!!!", first, last);
		result.setMessage(message);
		return result;
	}
}

