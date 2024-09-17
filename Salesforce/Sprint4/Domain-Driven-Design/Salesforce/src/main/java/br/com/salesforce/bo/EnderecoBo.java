package br.com.salesforce.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.salesforce.dao.EnderecoDao;
import br.com.salesforce.modelo.Endereco;

public class EnderecoBo {

	EnderecoDao enderecoDAO;

	public void inserirBo(Endereco endereco) {
		enderecoDAO = new EnderecoDao();
		enderecoDAO.inserir(endereco);
	}

	public List<Endereco> visualizarBo() {
		enderecoDAO = new EnderecoDao();
		return (ArrayList<Endereco>) enderecoDAO.visualizar();
	}

}
