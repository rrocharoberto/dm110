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

	// TODO: create attributes

	public void sendTextMessage(String text) {
		// TODO: implement it
	}

	@Inject
	Logger log;
}
