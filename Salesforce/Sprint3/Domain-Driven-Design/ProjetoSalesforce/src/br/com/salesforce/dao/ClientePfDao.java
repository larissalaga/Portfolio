package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.ClientePf;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ClientePfDao {

	public Connection minhaConexao;

	public ClientePfDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(ClientePf clientePf) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_CLIENTE_PF values(?,?,?,?,?,?)");

		stmt.setString(1, clientePf.getCpf());
		stmt.setString(2, clientePf.getProfissao());
		stmt.setString(3, clientePf.getEscolaridade());
		stmt.setString(4, clientePf.getDtNascimento());
		stmt.setString(5, clientePf.getSexo());
		stmt.setInt(6, clientePf.getCodigo());
		stmt.execute();
		stmt.close();

		return "Cliente Pessoa Física cadastrado com sucesso";
	}

	public List<ClientePf> visualizar() throws SQLException {
		List<ClientePf> listaPf = new ArrayList<ClientePf>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_CLIENTE_PF");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ClientePf clPf = new ClientePf();
			clPf.setCpf(rs.getString(1));
			clPf.setProfissao(rs.getString(2));
			clPf.setEscolaridade(rs.getString(3));
			clPf.setDtNascimento(rs.getString(4));
			clPf.setSexo(rs.getString(5));
			clPf.setCodigo(rs.getInt(6));
			listaPf.add(clPf);
		}

		return listaPf;
	}

}
