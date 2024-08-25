package br.inatel.dm110.rest;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import br.inatel.dm110.impl.IbgeResource;
import br.inatel.dm110.impl.example.HelloResource;
import br.inatel.dm110.impl.example.MessageResource;
import br.inatel.dm110.impl.example.support.MessageExceptionMapper;

@ApplicationPath("/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

		//register the classes to publish the rest service
		// classes.add(IbgeResource.class);
		classes.add(HelloResource.class); 
		classes.add(MessageResource.class);
		classes.add(MessageExceptionMapper.class);
		return classes;
	}
}
