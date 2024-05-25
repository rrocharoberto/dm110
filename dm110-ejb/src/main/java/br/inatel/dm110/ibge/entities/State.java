package br.inatel.dm110.ibge.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class State implements Serializable {

	private static final long serialVersionUID = -3226154108429480413L;

	@Id
	private int ibge;
	private String sigla;
	private String nome;
	private float area;

	public State() {
	}

	public State(int ibge, String sigla, String nome, float area) {
		super();
		this.ibge = ibge;
		this.sigla = sigla;
		this.nome = nome;
		this.area = area;
	}

	public int getIbge() {
		return ibge;
	}

	public void setIbge(int ibge) {
		this.ibge = ibge;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}
}
