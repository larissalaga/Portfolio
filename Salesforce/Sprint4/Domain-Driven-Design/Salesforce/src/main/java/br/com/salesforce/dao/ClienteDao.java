package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.salesfoce.beans.Cliente;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ClienteDao {

	public Connection minhaConexao;

	public ClienteDao() {
		try {
			this.minhaConexao = new ConnectionFactory().conexao();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String inserir(Cliente cliente) {
		try {
			PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_CLIENTE values(?,?)");

			stmt.setInt(1, cliente.getCodigo());
			stmt.setString(2, cliente.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
