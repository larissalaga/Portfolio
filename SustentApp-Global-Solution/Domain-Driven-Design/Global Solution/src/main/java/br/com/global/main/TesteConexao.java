package br.com.global.main;

import java.sql.Connection;

import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            Connection cn = new ConnectionFactory().conexao();
            System.out.println("Conectado ao banco de dados com sucesso");
            cn.close();
        } catch (Exception e) {
            new Excecao(e);
        }
    }
}
