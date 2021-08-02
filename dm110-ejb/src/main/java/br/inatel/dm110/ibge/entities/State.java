package br.inatel.dm110.ibge.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO", schema = "public")
public class State implements Serializable {

	private static final long serialVersionUID = -3226154108429480413L;

	public State() {} // default

	public State(int ibge, String sigla, String nome, float area) {
		super();
		this.ibge = ibge;
		this.sigla = sigla;
		this.nome = nome;
		this.area = area;
	}

	@Id
	private int ibge;
	private String sigla;
	private String nome;
	private float area;

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
