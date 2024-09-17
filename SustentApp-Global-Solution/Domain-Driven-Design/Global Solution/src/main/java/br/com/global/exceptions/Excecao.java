package br.com.global.exceptions;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;

public class Excecao extends Exception {
	private static final long serialVersionUID = 1L;

	public Excecao() {
		super();
	}
	
    public Excecao(Exception e) {
        super();
        if (e.getClass().equals(ClassNotFoundException.class)) {
            System.out.println("Classe não encontrada.");
        } else if (e.getClass().equals(SQLException.class)) {
            System.out.println("Erro de SQL.");
        } else if (e.getClass().equals(ClientProtocolException.class)) {
            System.out.println("Erro de protocolo do cliente.");
        } else if (e.getClass().equals(IOException.class)) {
            System.out.println("Erro de I/O.");
        } else {
            System.out.println("Falha desconhecida.");
            e.printStackTrace();
        }
    }
	
	

}
