package br.com.salesforce.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.Contato;
import br.com.salesforce.dao.ContatoDao;

public class ContatoBo {

	ContatoDao contatoDAO;

	public void inserirBo(Contato contato) {
		contatoDAO = new ContatoDao();
		contatoDAO.inserir(contato);
	}

	public List<Contato> visualizarBo() {
		contatoDAO = new ContatoDao();
		return (ArrayList<Contato>) contatoDAO.visualizar();
	}

}
