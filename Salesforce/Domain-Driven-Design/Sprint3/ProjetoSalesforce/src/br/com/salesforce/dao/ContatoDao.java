package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.Contato;
import br.com.salesforce.conexoes.ConnectionFactory;

public class ContatoDao {

	public Connection minhaConexao;

	public ContatoDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(Contato contato) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_CONTATO values(?,?,?,?)");

		stmt.setString(1, contato.getTelCelular());
		stmt.setString(2, contato.getTelFixo());
		stmt.setString(3, contato.getEmail());
		stmt.setInt(4, contato.getId());
		stmt.execute();
		stmt.close();

		return "Contato cadastrado com sucesso";
	}

	public List<Contato> visualizar() throws SQLException {
		List<Contato> listaContato = new ArrayList<Contato>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_CONTATO");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Contato contato = new Contato();
			contato.setTelCelular(rs.getString(1));
			contato.setTelFixo(rs.getString(2));
			contato.setEmail(rs.getString(3));
			contato.setId(rs.getInt(4));
			listaContato.add(contato);
		}

		return listaContato;
	}
}
