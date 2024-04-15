package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.ClientePj;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ClientePjDao {

	public Connection minhaConexao;

	public ClientePjDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(ClientePj clientePj) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_CLIENTE_PJ values(?,?,?,?)");

		stmt.setString(1, clientePj.getCnpj());
		stmt.setString(2, clientePj.getRazaoSocial());
		stmt.setInt(3, clientePj.getQtFuncionarios());
		stmt.setInt(4, clientePj.getCodigo());
		stmt.execute();
		stmt.close();

		return "Cliente Pessoa Juridica cadastrado com sucesso";
	}

	public List<ClientePj> visualizar() throws SQLException {
		List<ClientePj> listaPj = new ArrayList<ClientePj>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_CLIENTE_PJ");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ClientePj clPj = new ClientePj();
			clPj.setCnpj(rs.getString(1));
			clPj.setRazaoSocial(rs.getString(2));
			clPj.setQtFuncionarios(rs.getInt(3));
			clPj.setCodigo(rs.getInt(4));
			listaPj.add(clPj);
		}

		return listaPj;
	}
}
