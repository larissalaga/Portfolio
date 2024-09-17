package br.com.global.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.global.exceptions.Excecao;

public class ConnectionFactory {

    public Connection conexao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm552473", "080100");
        } catch (ClassNotFoundException | SQLException e) {
            new Excecao(e);
            return null;
        }
    }
}
