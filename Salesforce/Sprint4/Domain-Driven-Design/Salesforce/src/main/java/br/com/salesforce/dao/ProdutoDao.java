package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.Produto;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ProdutoDao {

	public Connection minhaConexao;

	public ProdutoDao() {
		try {
			this.minhaConexao = new ConnectionFactory().conexao();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String inserir(Produto produto) {
		try {
			PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_PRODUTO values(?,?,?,?,?)");

			stmt.setInt(1, produto.getCodigo());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getPrazoLicensa());
			stmt.setDouble(4, produto.getValorProduto());
			stmt.setInt(5, produto.getId());
			stmt.execute();
			stmt.close();

			return "Produto cadastrado com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Produto> visualizar() {
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {
			PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_PRODUTO");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPrazoLicensa(rs.getString(3));
				produto.setValorProduto(rs.getDouble(4));
				produto.setId(rs.getInt(5));
				listaProduto.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProduto;
	}
}
