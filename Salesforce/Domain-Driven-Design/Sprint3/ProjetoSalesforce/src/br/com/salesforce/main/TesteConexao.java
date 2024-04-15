package br.com.salesforce.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.salesforce.conexoes.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection cn = new ConnectionFactory().conexao();
		System.out.println("Conectado ao banco de dados com sucesso");
		cn.close();

	}

}
