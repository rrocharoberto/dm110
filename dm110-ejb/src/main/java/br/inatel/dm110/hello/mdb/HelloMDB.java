package br.inatel.dm110.hello.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", 
									propertyValue = "javax.jms.Queue"),

		@ActivationConfigProperty(propertyName = "destination", 
									propertyValue = "java:/jms/queue/dm110queue"),

		@ActivationConfigProperty(propertyName = "maxSession", propertyValue = "5") })

public class HelloMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMessage = (TextMessage) message;

				String text = txtMessage.getText();

				System.out.println("Iniciando processamento da mensagem...");
				Thread.sleep(5000);
				System.out.println("Mensagem recebida por HelloMDB: " + text);
				System.out.println("Finalizando processamento da mensagem...");
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
