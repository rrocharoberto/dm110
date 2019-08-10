package br.inatel.dm110.ibge.to;

import java.io.Serializable;

public class StateTO implements Serializable {

	private static final long serialVersionUID = 4512919275841995921L;

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
