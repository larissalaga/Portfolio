package br.com.global.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.global.connections.ConnectionFactory;

public class TesteConexao {

	public static void main(String[] args) {
		try {
			Connection cn = new ConnectionFactory().conexao();
			System.out.println("Conectado ao banco de dados com sucesso");
			cn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
