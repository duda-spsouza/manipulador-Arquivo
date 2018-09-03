package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import negocios.*;

public class Writer {
	
	private Date atualDate = new Date();
	private ClienteManager clientemanager = new ClienteManager();
	private VendasManager vendasmanager = new VendasManager();
	private VendedorManager vendedormanager = new VendedorManager();
	
	SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy_HHmmss");

	public Writer() {
		this.clientemanager.getClienteList();
		this.vendasmanager.getVendasList();
		this.vendedormanager.getVendedorList();
	}

	public void createFileWithResult() {
		FileWriter arquivo;
		try {
			arquivo = new FileWriter(new File("C:\\Users\\Duda\\data\\out\\"+df.format(atualDate)+".done.dat"));
			arquivo.write("Quantidade de clientes no arquivo de entrada: " + clientemanager.TotalClientes() + "\r\n"
					+ "Quantidade de vendedor no arquivo de entrada: " + vendedormanager.TotalVendedores() + "\r\n"
					+ "ID da venda mais cara: " + vendasmanager.getIdVendaCara() + "\r\n"
					+ "Pior Vendedor: " + vendasmanager.getPiorVenda());
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
