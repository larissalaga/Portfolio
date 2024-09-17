package br.com.salesforce.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.ClientePj;
import br.com.salesforce.dao.ClientePjDao;

public class ClientePjBo {

	ClientePjDao clientePjDAO;

	public void inserirBo(ClientePj clientePj) {
		clientePjDAO = new ClientePjDao();
		clientePjDAO.inserir(clientePj);
	}

	public List<ClientePj> visualizarBo() {
		clientePjDAO = new ClientePjDao();
		return (ArrayList<ClientePj>) clientePjDAO.visualizar();
	}

}
