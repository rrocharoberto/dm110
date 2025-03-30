package br.inatel.dm110.api.example;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageTO implements Serializable {

	private static final long serialVersionUID = -5106558229027863908L;

	public MessageTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	private String firstName;
	private String lastName;
	private String message;
}