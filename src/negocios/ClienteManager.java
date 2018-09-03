package negocios;

import java.util.ArrayList;
import java.util.List;

import persistence.Reader;
import entidade.*;

public class ClienteManager {
	
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public void getClienteList() {
		for (String customer : Reader.getArcFormated()) {
			if (customer.startsWith("002ç")) {
				String aux[] = customer.split("ç");
				clientes.add(new Cliente(aux[1], aux[2], aux[3]));
			}
		}
	}

	public int TotalClientes() {
		return clientes.size();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
