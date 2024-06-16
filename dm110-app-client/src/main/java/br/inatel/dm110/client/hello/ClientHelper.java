package br.inatel.dm110.client.hello;

import java.util.Properties;

import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientHelper {

	// configura as propriedades de acesso ao container JEE
	public static Context createInitialContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
		return new InitialContext(jndiProperties);
	}

	public static void closeInitialContext(Context initialContext) {
		if (initialContext != null) {
			try {
				initialContext.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeJMSContext(JMSContext context) {
		if (context != null) {
			context.close();
		}
	}
}