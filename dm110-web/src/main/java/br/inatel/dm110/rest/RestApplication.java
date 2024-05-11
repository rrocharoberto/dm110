package br.inatel.dm110.rest;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import br.inatel.dm110.impl.example.HelloResource;
import br.inatel.dm110.impl.example.MessageResource;
import br.inatel.dm110.impl.example.support.MessageExceptionMapper;

@ApplicationPath("/api")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(HelloResource.class); //register the class to publish the rest service
		classes.add(MessageResource.class); //register the class to publish the rest service
		classes.add(MessageExceptionMapper.class); //register the class to handle exceptions
		return classes;
	}
}
