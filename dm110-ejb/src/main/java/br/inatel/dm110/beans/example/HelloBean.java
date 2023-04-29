package br.inatel.dm110.beans.example;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.beans.example.dao.HelloMemoryDAO;
import br.inatel.dm110.interfaces.example.HelloLocal;
import br.inatel.dm110.interfaces.example.HelloRemote;

@Stateless
@Local(HelloLocal.class)
@Remote(HelloRemote.class)
public class HelloBean implements HelloRemote {

	private static Logger log = Logger.getLogger(HelloBean.class.getName());

	// in memory cache
	private HelloMemoryDAO dao = new HelloMemoryDAO();
	
	@Override
	public String sayHello(String name) {
		log.info("Chamou o Hello Bean: " + name);
		return "Hello Session Bean greeting " + name + " !";
	}

	@Override
	public MessageTO getMessage(Integer id) {
		return dao.getMessage(id);
	}

	@Override
	public int storeNewMessage(MessageTO message) {
		return dao.storeNewMessage(message);
	}

	@Override
	public List<MessageTO> getAllMessages() {
		return dao.getMessages();
	}
}
