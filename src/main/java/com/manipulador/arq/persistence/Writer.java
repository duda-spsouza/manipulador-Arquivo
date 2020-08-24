package com.manipulador.arq.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.manipulador.arq.negocio.ClienteManager;
import com.manipulador.arq.negocio.VendasManager;
import com.manipulador.arq.negocio.VendedorManager;
import com.manipulador.arq.util.Config;

public class Writer {
	private Date atualDate = new Date();
	private ClienteManager clientemanager = new ClienteManager();
	private VendasManager vendasmanager = new VendasManager();
	private VendedorManager vendedormanager = new VendedorManager();
	
	Config  config = new Config();
	
	SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy_HHmmss");

	public Writer() {
		this.clientemanager.getClienteList();
		this.vendasmanager.getVendasList();
		this.vendedormanager.getVendedorList();
	}

	public void createFileWithResult() {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File(config.PATH_SAIDA+"\\"+df.format(atualDate)+".done.dat"));
			arquivo.write("Quantidade de clientes no arquivo de entrada: " + clientemanager.TotalClientes() + "\r\n"
					+ "Quantidade de vendedor no arquivo de entrada: " + vendedormanager.TotalVendedores() + "\r\n"
					+ "ID da venda mais cara: " + vendasmanager.getIdVendaCara() + "\r\n"
					+ "Pior Vendedor: " + vendasmanager.getPiorVenda());
			arquivo.close();
			System.out.println("Arquivo Criado... Por favor verificar o diretório:"+config.PATH_SAIDA);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
