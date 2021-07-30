package br.inatel.dm110.beans.example;

import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.interfaces.example.HelloLocal;
import br.inatel.dm110.interfaces.example.HelloRemote;

@Stateless
@Remote(HelloRemote.class)
@Local(HelloLocal.class)

public class HelloBean implements HelloLocal, HelloRemote {

	private static Logger log = Logger.getLogger(HelloBean.class.getName());

	@Override
	public String sayHello(String name) {
		log.info("Chamou o Hello Bean: " + name);
		return "Hello from Session Bean: " + name + " !";
	}
}
