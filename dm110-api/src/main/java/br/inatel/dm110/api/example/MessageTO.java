package br.inatel.dm110.api.example;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageTO implements Serializable {

	private static final long serialVersionUID = -5106558229027863908L;

	private String firstName;
	private String lastName;
	private String message;
	
}