package br.inatel.dm110.beans.example;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Queue;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Stateless
public class HelloQueueSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/dm110queue")
	private Queue queue;

	public void sendTextMessage(String text) {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(queue);
			TextMessage txtMsg = session.createTextMessage(text);
			msgProducer.send(txtMsg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
