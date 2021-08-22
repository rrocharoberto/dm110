package br.inatel.dm110.beans.example;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", 
								  propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", 
								  propertyValue = "java:/jms/topic/dm110topic") })

public class HelloTopicMDB implements MessageListener {
	
	private static Logger log = Logger.getLogger(HelloTopicMDB.class.getName());

	@Override
	public void onMessage(Message message) {
		//processamento da mensagem
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMessage = (TextMessage) message;
				String text = txtMessage.getText();
				log.info("Mensagem recebida do tópico: " + text);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
