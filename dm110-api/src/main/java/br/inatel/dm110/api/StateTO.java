package br.inatel.dm110.api;

import java.io.Serializable;

public class StateTO implements Serializable {

	private int ibge;
	private String nome;
	private String sigla;
	private float area;
	

	public int getIbge() {
		return ibge;
	}
	public void setIbge(int ibge) {
		this.ibge = ibge;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
}
