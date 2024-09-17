package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.CadastroPF;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class CadastroPfDao {

    public Connection minhaConexao;

    public CadastroPfDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }

    public String inserir(CadastroPF cadastroPf) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_cadastropf values(?,?,?)");

            stmt.setString(1, cadastroPf.getNome());
            stmt.setString(2, cadastroPf.getEmail());
            stmt.setString(3, cadastroPf.getCep());
            stmt.execute();
            stmt.close();
            return null;
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao inserir cadastro.";
        }
    }

    public List<CadastroPF> visualizar() {
        List<CadastroPF> listaCadastroPF = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_cadastropf");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CadastroPF cadastroPf = new CadastroPF();
                cadastroPf.setNome(rs.getString(1));
                cadastroPf.setEmail(rs.getString(2));
                cadastroPf.setCep(rs.getString(3));

                listaCadastroPF.add(cadastroPf);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaCadastroPF;
    }
}
