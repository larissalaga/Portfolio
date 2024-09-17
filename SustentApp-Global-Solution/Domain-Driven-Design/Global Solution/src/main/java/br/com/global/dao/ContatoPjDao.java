package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.ContatoPJ;
import br.com.global.beans.Empresa;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class ContatoPjDao {

    public Connection minhaConexao;

    public ContatoPjDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }

    public String inserir(ContatoPJ contatoPj) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_contatopj values(?,?,?)");

            stmt.setString(1, contatoPj.getEmail());
            stmt.setString(2, contatoPj.getTel());
            stmt.setString(3, contatoPj.getEmpresa().getCnpj());
            stmt.execute();
            stmt.close();
            return "Contato da Empresa cadastrado com sucesso";
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao cadastrar contato da Empresa.";
        }
    }

    public List<ContatoPJ> visualizar() {
        List<ContatoPJ> listaContatoPJ = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_contatopj");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ContatoPJ contatoPj = new ContatoPJ();
                contatoPj.setEmail(rs.getString(1));
                contatoPj.setTel(rs.getString(2));

                Empresa empresa = new Empresa();
                empresa.setCnpj(rs.getString(3));

                contatoPj.setEmpresa(empresa);

                listaContatoPJ.add(contatoPj);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaContatoPJ;
    }
}
