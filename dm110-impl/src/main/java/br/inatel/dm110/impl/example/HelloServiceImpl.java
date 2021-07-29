package br.inatel.dm110.impl.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.MessageTO;
import br.inatel.dm110.api.example.HelloService;

@RequestScoped
public class HelloServiceImpl implements HelloService {

	static private int count = 0;

	// test: in memory storage
	static private Map<Integer, MessageTO> cache = new HashMap<>();

	@Override
	public String sayHello(String name) {
		String message = "Hello " + name;
		return "<h1>" + message + "</h1>";
	}

	@Override
	public Response getMessage(Integer id) {
		if (cache.containsKey(id)) {
			return Response.ok(cache.get(id)).build();
		}
		return Response.noContent().build();
	}

	@Override
	public MessageTO postMessage(String first, String last) {
		MessageTO result = new MessageTO();
		result.setFirstName(first);
		result.setLastName(last);
		String message = String.format("Hello %s %s!!!", first, last);
		result.setMessage(message);
		return result;
	}

	@Override
	public int storeNewMessage(MessageTO message) {
		message.setMessage("Hello " + message.getFirstName() + " " + message.getLastName());
		System.out.println("Message created: " + message.getMessage());
		count++;
		cache.put(count, message);
		return count;
	}

	@Override
	public Collection<MessageTO> getMessages() {
		return cache.values();
	}
}
