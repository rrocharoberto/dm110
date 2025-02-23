package br.inatel.dm110.api.ibge;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StateTO implements Serializable {
	private int ibge;
	private String nome;
	private String sigla;
	private float area;
}
