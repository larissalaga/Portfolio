package br.com.salesforce.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.ClientePf;
import br.com.salesforce.dao.ClientePfDao;

public class ClientePfBo {

	ClientePfDao clientePfDAO;

	public void inserirBo(ClientePf clientePf) {
		clientePfDAO = new ClientePfDao();
		clientePfDAO.inserir(clientePf);
	}

	public List<ClientePf> visualizarBo() {
		clientePfDAO = new ClientePfDao();
		return (ArrayList<ClientePf>) clientePfDAO.visualizar();
	}

}
