package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Representante;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class RepresentanteDao {

    public Connection minhaConexao;

    public RepresentanteDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }

    public String inserir(Representante representante) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_representante values(?,?)");

            stmt.setString(1, representante.getCpf());
            stmt.setString(2, representante.getNome());
            stmt.execute();
            stmt.close();
            return "Representante cadastrado com sucesso";
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao cadastrar representante.";
        }
    }

    public List<Representante> visualizar() {
        List<Representante> listaRepresentante = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_representante");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Representante representante = new Representante();
                representante.setCpf(rs.getString(1));
                representante.setNome(rs.getString(2));

                listaRepresentante.add(representante);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaRepresentante;
    }
}
