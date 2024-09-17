package br.com.salesforce.bo;

import br.com.salesfoce.beans.Cliente;
import br.com.salesforce.dao.ClienteDao;

public class ClienteBo {

	ClienteDao clienteDao;

	public void inserirBo(Cliente cliente) {
		clienteDao = new ClienteDao();
		clienteDao.inserir(cliente);
	}

}
