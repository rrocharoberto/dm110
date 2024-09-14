package br.inatel.dm110.ibge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ESTADO")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class State {

	@Id
	private int ibge;
	private String sigla;
	private String nome;
	private float area;
}
