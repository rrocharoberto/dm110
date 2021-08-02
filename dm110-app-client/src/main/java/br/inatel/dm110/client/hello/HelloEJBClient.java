package br.inatel.dm110.client.hello;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.inatel.dm110.interfaces.example.HelloRemote;

public class HelloEJBClient {

	public static void main(String[] args) throws Exception {
		// Invoke a stateless bean
		invokeStatelessBean();

	}

	/**
	 * Looks up a stateless bean and invokes on it
	 *
	 * @throws NamingException
	 */
	private static void invokeStatelessBean() throws NamingException {
		// Let's lookup the remote stateless object
		final HelloRemote statelessRemoteHello = lookupRemoteStatelessHello();
		System.out.println("Obtained a remote stateless hello for invocation");
		// invoke on the remote object
		String result = statelessRemoteHello.sayHello("Roberto");
		System.out.println("Resultado da chamada remota: " + result);
	}

	/**
	 * Looks up and returns the proxy to remote stateless hello bean
	 *
	 * @return
	 * @throws NamingException
	 */
	private static HelloRemote lookupRemoteStatelessHello() throws NamingException {
		// ejb:dm110-ear-1.0/dm110-ejb-1.0/HelloBean!br.inatel.dm110.hello.interfaces.HelloRemote
		final Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		final Context context = new InitialContext(jndiProperties);
		final String appName = "dm110-ear-1.0";
		final String moduleName = "dm110-ejb-1.0";
		final String beanName = "HelloBean";
		final String remoteInterfaceName = HelloRemote.class.getName();
		return (HelloRemote) context
				.lookup("ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + remoteInterfaceName);
	}

}