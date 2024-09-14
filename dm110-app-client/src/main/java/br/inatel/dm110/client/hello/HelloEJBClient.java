package br.inatel.dm110.client.hello;

import javax.naming.Context;
import javax.naming.NamingException;

import br.inatel.dm110.api.example.MessageTO;
import br.inatel.dm110.interfaces.example.HelloLocal;
import br.inatel.dm110.interfaces.example.HelloRemote;

public class HelloEJBClient {

	public static void main(String[] args) throws Exception {
		invokeSessionBean();
	}

	private static void invokeSessionBean() throws NamingException {

		final HelloRemote hello = lookupSessionHello();
		if (hello != null) {
			// invoca a chamada no objeto remoto
			MessageTO result = hello.sayHello("Ricardo");
			System.out.println("Resultado da chamada ao session bean: " + result);
		} else {
			System.out.println("Objeto session bean remoto não encontrado.");
		}
	}

	private static HelloRemote lookupSessionHello() throws NamingException {
		// faz o lookup do EJB (objeto) session bean

		String appName = "dm110-ear-1.0";
		String moduleName = "dm110-ejb-1.0";
		String beanName = "HelloBean";
		String interfaceName = HelloRemote.class.getName();

		// nome completo do EJB
		String jndiName = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + interfaceName;
		System.out.println("JNDI Name: " + jndiName);
		Context context = ClientHelper.createInitialContext();
		return (HelloRemote) context.lookup(jndiName);
	}
}
