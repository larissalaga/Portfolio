package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesforce.conexoes.ConnectionFactory;
import br.com.salesforce.modelo.Endereco;

public class EnderecoDao {

	public Connection minhaConexao;

	public EnderecoDao() {
		try {
			this.minhaConexao = new ConnectionFactory().conexao();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String inserir(Endereco endereco) {
		try {
			PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_ENDERECO values(?,?,?,?,?,?,?)");

			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setInt(3, endereco.getNum());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getLocalidade());
			stmt.setString(6, endereco.getUf());
			stmt.setInt(7, endereco.getId());
			stmt.execute();
			stmt.close();

			return "Endereço cadastrado com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Endereco> visualizar() {
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		try {
			PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_ENDERECO");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setCep(rs.getString(1));
				endereco.setLogradouro(rs.getString(2));
				endereco.setNum(rs.getInt(3));
				endereco.setComplemento(rs.getString(4));
				endereco.setLocalidade(rs.getString(5));
				endereco.setUf(rs.getString(6));
				endereco.setId(rs.getInt(7));
				listaEndereco.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaEndereco;
	}
}
