package br.inatel.dm110.client.hello;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloTopicClient {
	
	private static final Logger log = Logger.getLogger(HelloTopicClient.class.getName());

	private static final String CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String DESTINATION = "java:jms/topic/dm110topic";
	private static final String USERNAME = "jmsuser";
	private static final String PASSWORD = "senhajms";

	public static void main(String[] args) {
		sendMessage("Olá de Topic Client.");
	}

	public static void sendMessage(String message) {
		Context initialContext = null;
		JMSContext jmsContext = null;
		try {
			initialContext = ClientHelper.createInitialContext();
			jmsContext = createContext(initialContext);
			log.info("Context ok");
			
			// Faz lookup do tópico
			Destination destination = (Destination) initialContext.lookup(DESTINATION);
			log.info("Destination ok");

			JMSProducer producer = jmsContext.createProducer();
			log.info("JMSProducer ok");

			log.info("Enviando mensagem: " + message);
			producer.send(destination, message);
			log.info("Enviou mensagem com sucesso ao tópico.");

		} catch (NamingException e) {
			log.log(Level.SEVERE, "Erro enviando mensagem ao tópico.", e);
		} finally {
			ClientHelper.closeJMSContext(jmsContext);
			ClientHelper.closeInitialContext(initialContext);
		}
	}

	private static JMSContext createContext(Context initialContext) throws NamingException {
		// Faz lookup da factory
		TopicConnectionFactory connectionFactory = (TopicConnectionFactory) initialContext.lookup(CONNECTION_FACTORY);
		log.info("ConnectionFactory ok");

		JMSContext JMScontext = connectionFactory.createContext(USERNAME, PASSWORD);
		log.info("JMSContext ok");
		return JMScontext;
	}

//	private static void receiveMessage(JMSContext jmsContext, Destination destination) {
//		 // Create the JMS consumer
//		 JMSConsumer consumer = jmsContext.createConsumer(destination);
//		 // Receive the message that were sent
//		 String text = consumer.receiveBody(String.class, 5000);
//		 log.info("Mensagem recebida: " + text);
//	}

}