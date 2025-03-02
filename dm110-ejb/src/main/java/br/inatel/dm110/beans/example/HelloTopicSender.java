package br.inatel.dm110.beans.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.TextMessage;
import jakarta.jms.Topic;

@Stateless
public class HelloTopicSender {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory; // igual à fila
	@Resource(lookup = "java:/jms/topic/dm110topic")
	private Topic topic;

	public void sendTextMessage(String text) {
		try (JMSContext context = connectionFactory.createContext();) {
			TextMessage txtMsg = context.createTextMessage(text);
			context.createProducer().send(topic, txtMsg);
		} catch (Exception e) {
			// handle the exception properly
			log.log(Level.SEVERE, "Error sending message: " + text, e);
		}
	}

	@Inject
	Logger log;
}
