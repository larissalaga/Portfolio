package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.ContatoPF;
import br.com.global.beans.Representante;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class ContatoPfDao {
    
    public Connection minhaConexao;

    public ContatoPfDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }
    
    public String inserir(ContatoPF contatoPf) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_contatopf values(?,?,?)");

            stmt.setString(1, contatoPf.getEmail());
            stmt.setString(2, contatoPf.getTel());
            stmt.setString(3, contatoPf.getRepresentante().getCpf());
            stmt.execute();
            stmt.close();
            return "Contato de Representante cadastrado com sucesso";
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao cadastrar contato de Representante.";
        }
    }

    public List<ContatoPF> visualizar() {
        List<ContatoPF> listaContatoPF = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_contatopf");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ContatoPF contatoPf = new ContatoPF();
                contatoPf.setEmail(rs.getString(1));
                contatoPf.setTel(rs.getString(2));
                
                Representante representante = new Representante();
                representante.setCpf(rs.getString(3));
                
                contatoPf.setRepresentante(representante);

                listaContatoPF.add(contatoPf);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaContatoPF;
    }
}
