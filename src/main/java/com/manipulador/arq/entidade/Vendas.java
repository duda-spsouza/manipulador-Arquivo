package com.manipulador.arq.entidade;

public class Vendas {
	private String saleid;
	private double saleprice;
	private String salesman;

	public Vendas(String saleid, double saleprice, String saleman) {
		this.saleid = saleid;
		this.saleprice = saleprice;
		this.salesman = saleman;
	}

	public double getSalePrice() {
		return saleprice;
	}

	public String getSalesman() {
		return salesman;
	}

	public String getSaleId() {
		return saleid;
	}

}
