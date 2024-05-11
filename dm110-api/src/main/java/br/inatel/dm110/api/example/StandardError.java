package br.inatel.dm110.api.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardError {

	private int status;
	private String message;
	
}