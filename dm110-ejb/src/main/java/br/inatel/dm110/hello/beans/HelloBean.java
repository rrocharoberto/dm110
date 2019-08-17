package br.inatel.dm110.hello.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.hello.interfaces.HelloLocal;
import br.inatel.dm110.hello.interfaces.HelloRemote;

@Stateless
@Remote(HelloRemote.class)
@Local(HelloLocal.class)
public class HelloBean implements HelloLocal, HelloRemote {

	@EJB
	private HelloMessageSender msgSender;
	
	@Override
	public String sayHello(String name) {
		
		msgSender.sendHelloMessage(name);
		System.out.println("Mensagem enviada para o Hello MDB.");
		
		return "HelloBean saying hello to " + name;
	}
}
