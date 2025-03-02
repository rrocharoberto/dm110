package br.inatel.dm110.beans.example;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/dm110queue") })
public class HelloQueueMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		// processamento da mensagem
		log.info("Running method onMessage: " + message);
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMessage = (TextMessage) message;
				String text = txtMessage.getText();
				log.info("Message received from queue: " + text);
			}
		} catch (JMSException e) {
			log.log(Level.SEVERE, "Error processing message: " + message, e);
		}
	}

	@Inject
	Logger log;
}
