package br.inatel.dm110.beans.example;

import java.util.logging.Logger;

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
	private ConnectionFactory connectionFactory; // igual à fila

	@Resource(lookup = "java:/jms/topic/dm110topic")
	private Topic topic;
	
	private static Logger log = Logger.getLogger(HelloTopicSender.class.getName());

	public void sendTextMessage(String text) {
		try {
			Connection conn = connectionFactory.createConnection();
			Session session = conn.createSession();
			MessageProducer msgProducer = session.createProducer(topic);
			TextMessage txtMsg = session.createTextMessage(text);
			msgProducer.send(txtMsg);
			log.info("Enviou a mensagem: " + txtMsg);
		} catch (JMSException e) {
			System.out.println("Erro enviando mensagem: " + text);
			throw new RuntimeException(e);
		}
	}
}
