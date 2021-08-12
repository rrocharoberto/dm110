package br.inatel.dm110.beans.example;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

@Stateless
public class HelloTopicSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/topic/dm110topic") // o tópico está configurada no container
	private Topic topic;

	public void sendTextMessage(String text) {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(topic);
			TextMessage txtMsg = session.createTextMessage(text);
			msgProducer.send(txtMsg);
		} catch (JMSException e) {
			System.out.println("Erro enviando mensagem: " + text);
			throw new RuntimeException(e);
		}
	}
}
