package br.inatel.dm110.client.ibge;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.client.hello.ClientHelper;
import br.inatel.dm110.interfaces.ibge.IbgeRemote;

public class IbgeEJBClient {

	public static void main(String[] args) throws Exception {
		invokeSessionBean();
	}

	private static void invokeSessionBean() throws NamingException {

		final IbgeRemote ibgeBean = lookupSessionHello();
		if (ibgeBean != null) {
			// invoca a chamada no objeto remoto
			List<StateTO> result = ibgeBean.listarTodosEstados();
			System.out.println("Resultado da chamada ao session bean: " + result);
		} else {
			System.out.println("Objeto session bean remoto não encontrado.");
		}
	}

	private static IbgeRemote lookupSessionHello() throws NamingException {
		// faz o lookup do EJB (objeto) session bean

		String appName = "dm110-ear-1.0";
		String moduleName = "dm110-ejb-1.0";
		String beanName = "IbgeBean";
		String interfaceName = IbgeRemote.class.getName();

		// nome completo do EJB
		String jndiName = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + interfaceName;
		System.out.println("JNDI Name: " + jndiName);
		Context context = ClientHelper.createInitialContext();
		return (IbgeRemote) context.lookup(jndiName);
	}
}
