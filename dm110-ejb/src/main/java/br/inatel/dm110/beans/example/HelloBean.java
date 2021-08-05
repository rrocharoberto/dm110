package br.inatel.dm110.beans.example;

import java.util.logging.Logger;

import br.inatel.dm110.interfaces.example.HelloLocal;

public class HelloBean implements HelloLocal {

	private static Logger log = Logger.getLogger(HelloBean.class.getName());

	@Override
	public String sayHello(String name) {
		log.info("Chamou o Hello Bean: " + name);
		return "Hello Session Bean greeting " + name + " !";
	}
}
