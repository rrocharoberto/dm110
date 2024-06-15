package br.inatel.dm110.beans.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;

@Stateless
public class HelloTopicSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory; // igual à fila

	@Resource(lookup = "java:/jms/topic/dm110topic")
	private Topic topic;

	@Inject
	Logger log;

	public void sendTextMessage(String text) {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(topic);
			TextMessage txtMsg = session.createTextMessage(text);
			msgProducer.send(txtMsg);
		} catch (JMSException e) {
			log.log(Level.SEVERE, "Erro enviando mensagem: " + text);
			throw new RuntimeException(e);
		}
	}
}
