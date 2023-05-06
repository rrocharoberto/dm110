package br.inatel.dm110.beans.example;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.impl.example.HelloMemoryDAO;
import br.inatel.dm110.interfaces.example.HelloLocal;
import br.inatel.dm110.interfaces.example.HelloRemote;

@Stateless
@Local(HelloLocal.class)
@Remote(HelloRemote.class)
public class HelloBean implements HelloLocal, HelloRemote {

	private static Logger log = Logger.getLogger(HelloBean.class.getName());

	// in memory cache
	private HelloMemoryDAO dao = new HelloMemoryDAO();
	
	@EJB
	private HelloQueueSender queueSender;
	
	@EJB
	private HelloTopicSender topicSender;

	@Override
	public String sayHello(String name) {
		log.info("Chamou o Hello Bean: " + name);
		String msg = "Hello Session Bean greeting " + name + " !";
		//send the message to somewhere
		queueSender.sendTextMessage(msg);
		topicSender.sendTextMessage(msg);
		return msg;
	}

	@Override
	public MessageTO getMessage(Integer id) {
		log.info("retrieving message: " + id);
		MessageTO msg = dao.getMessage(id);
		return msg;
	}

	@Override
	public int storeNewMessage(MessageTO message) {
		log.info("storing message: " + message);
		int id = dao.storeNewMessage(message);
		return id;
	}

	@Override
	public List<MessageTO> getAllMessages() {
		log.info("retrieving all messages.");
		return dao.getMessages();
	}
}
