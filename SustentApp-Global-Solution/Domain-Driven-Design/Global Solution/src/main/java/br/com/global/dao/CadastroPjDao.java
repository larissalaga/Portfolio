package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.CadastroPJ;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class CadastroPjDao {

    public Connection minhaConexao;

    public CadastroPjDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }

    public String inserir(CadastroPJ cadastroPj) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_cadastropj values(?,?,?,?)");

            stmt.setString(1, cadastroPj.getCnpj());
            stmt.setString(2, cadastroPj.getNomeFant());
            stmt.setString(3, cadastroPj.getEmail());
            stmt.setString(4, cadastroPj.getCep());
            stmt.execute();
            stmt.close();
            return null;
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao inserir cadastro.";
        }
    }

    public List<CadastroPJ> visualizar() {
        List<CadastroPJ> listaCadastroPJ = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_cadastropj");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CadastroPJ cadastroPj = new CadastroPJ();
                cadastroPj.setCnpj(rs.getString(1));
                cadastroPj.setNomeFant(rs.getString(2));
                cadastroPj.setEmail(rs.getString(3));
                cadastroPj.setCep(rs.getString(4));

                listaCadastroPJ.add(cadastroPj);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaCadastroPJ;
    }
}
