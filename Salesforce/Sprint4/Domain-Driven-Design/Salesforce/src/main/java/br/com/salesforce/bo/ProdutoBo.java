package br.com.salesforce.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.Produto;
import br.com.salesforce.dao.ProdutoDao;

public class ProdutoBo {

	ProdutoDao produtoDAO;

	public void inserirBo(Produto produto) {
		produtoDAO = new ProdutoDao();
		produtoDAO.inserir(produto);
	}

	public List<Produto> visualizarBo() {
		produtoDAO = new ProdutoDao();
		return (ArrayList<Produto>) produtoDAO.visualizar();
	}

}
