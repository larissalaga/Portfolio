package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.salesfoce.beans.Cliente;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ClienteDao {
	
	public Connection minhaConexao;
	
	public ClienteDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}
	
	public String inserir(Cliente cliente) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_CLIENTE values(?,?)");
		
		stmt.setInt(1, cliente.getCodigo());
		stmt.setString(2, cliente.getNome());
		stmt.execute();
		stmt.close();
		
		return null;
	}

}
