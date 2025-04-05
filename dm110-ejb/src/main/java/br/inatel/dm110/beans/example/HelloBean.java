package br.inatel.dm110.beans.example;

import java.util.logging.Logger;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.interfaces.example.HelloLocal;
import br.inatel.dm110.interfaces.example.HelloRemote;

@Stateless
public class HelloBean implements HelloLocal, HelloRemote {

	@Inject
	Logger log;

	@Override
	public String status() {
		log.info("Running status method in HelloBean.");
		return "Hello Session Bean Status ok.";
	}
	
	@Override
	public MessageTO sayHello(String name) {
		log.info("Running sayHello method in HelloBean with name: " + name);
		String msgStr = "Hello Session Bean greeting " + name + " !";
		MessageTO msg = new MessageTO(name, "");
		msg.setMessage(msgStr);
		return msg;
	}
}
