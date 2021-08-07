package br.inatel.dm110.ibge.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO", schema = "public")
public class State implements Serializable {

	private static final long serialVersionUID = -3226154108429480413L;

	public State() {} //default constructor
	
	public State(int ibge, String initials, String name, float area) {
		super();
		this.ibge = ibge;
		this.initials = initials;
		this.name = name;
		this.area = area;
	}

	@Id
	private int ibge;

	@Column(name = "SIGLA")
	private String initials;

	@Column(name = "NOME")
	private String name;
	private float area;

	public int getIbge() {
		return ibge;
	}

	public void setIbge(int ibge) {
		this.ibge = ibge;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "State [ibge=" + ibge + ", initials=" + initials + ", name=" + name + ", area=" + area + "]";
	}

}
