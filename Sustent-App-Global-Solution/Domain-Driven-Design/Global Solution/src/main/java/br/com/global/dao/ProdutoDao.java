package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.Empresa;
import br.com.global.beans.Produto;
import br.com.global.connections.ConnectionFactory;
import br.com.global.exceptions.Excecao;

public class ProdutoDao {

    public Connection minhaConexao;

    public ProdutoDao() {
        try {
            this.minhaConexao = new ConnectionFactory().conexao();
        } catch (Exception e) {
            new Excecao(e);
        }
    }

    public String inserir(Produto produto) {
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_produto values(?,?,?,?)");

            stmt.setString(1, produto.getTipo());
            stmt.setDouble(2, produto.getQuantidade());
            stmt.setString(3, produto.getReciclagem());
            stmt.setString(4, produto.getEmpresa().getCnpj());
            stmt.execute();
            stmt.close();
            return "Produto cadastrado com sucesso";
        } catch (SQLException e) {
            new Excecao(e);
            return "Erro ao cadastrar produto.";
        }
    }

    public List<Produto> visualizar() {
        List<Produto> listaProduto = new ArrayList<>();
        try {
            PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_produto");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setTipo(rs.getString(1));
                produto.setQuantidade(rs.getDouble(2));
                produto.setReciclagem(rs.getString(3));

                Empresa empresa = new Empresa();
                empresa.setCnpj(rs.getString(4));

                produto.setEmpresa(empresa);

                listaProduto.add(produto);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            new Excecao(e);
        }
        return listaProduto;
    }
}
