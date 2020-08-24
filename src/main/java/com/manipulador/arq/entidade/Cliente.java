package com.manipulador.arq.entidade;

public class Cliente {
	private String cnpj;
	private String name;
	private String businessarea;

	public Cliente(String cnpj, String name, String businessarea) {
		this.cnpj = cnpj;
		this.name = name;
		this.businessarea = businessarea;
	}

	public String getName() {
		return name;
	}

	public String getBusinessArea() {
		return businessarea;
	}

	public String getCNPJ() {
		return cnpj;
	}

}

