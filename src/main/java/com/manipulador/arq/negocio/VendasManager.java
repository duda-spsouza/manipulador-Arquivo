package com.manipulador.arq.negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.manipulador.arq.entidade.*;
import com.manipulador.arq.persistence.Reader;

public class VendasManager {
	
	private List<Vendas> vendas = new ArrayList<Vendas>();

	public void getVendasList() {
		for (String sale : Reader.getArcFormated()) {
			if (sale.startsWith("003ç")) {
				String aux[] = sale.split("ç");
				vendas.add(new Vendas(aux[1], getSalesPrice(aux[2]), aux[3]));
			}
		}
	}

	public int TotalVendas() {
		return vendas.size();
	}

	public List<Vendas> getVendas() {
		return vendas;
	}

	public double getSalesPrice(String sale) {
		double price = 0;
		String splitincoma[] = sale.split(",");
		for (int i = 0; i < splitincoma.length; i++) {
			String splitinindent[] = splitincoma[i].split("-");
			price = price + Double.parseDouble(splitinindent[1].replace("[", ""))
					* Double.parseDouble(splitinindent[2].replace("]", ""));
		}
		return price;
	}

	public String getIdVendaCara() {
		vendas.sort(Comparator.comparing(Vendas::getSalePrice).reversed());
		return vendas.get(0).getSaleId();
	}

	public String getPiorVenda() {
		vendas.sort(Comparator.comparing(Vendas::getSalePrice));
		return vendas.get(0).getSalesman();
	}

}
