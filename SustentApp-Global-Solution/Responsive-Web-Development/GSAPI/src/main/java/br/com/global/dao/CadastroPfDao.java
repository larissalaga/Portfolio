package br.com.global.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.CadastroPF;
import br.com.global.connections.ConnectionFactory;

public class CadastroPfDao {

	public Connection minhaConexao;

	public CadastroPfDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}

	public String inserir(CadastroPF cadastroPf) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into t_cadastropf values(?,?,?)");

		stmt.setString(1, cadastroPf.getNome());
		stmt.setString(2, cadastroPf.getEmail());
		stmt.setString(3, cadastroPf.getCep());
		stmt.execute();
		stmt.close();
		return null;

	}

	public List<CadastroPF> visualizar() throws SQLException {
		List<CadastroPF> listaCadastroPF = new ArrayList<CadastroPF>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from t_cadastropf");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			CadastroPF cadastroPf = new CadastroPF();
			cadastroPf.setNome(rs.getString(1));
			cadastroPf.setEmail(rs.getString(2));
			cadastroPf.setCep(rs.getString(3));

			listaCadastroPF.add(cadastroPf);
		}

		return listaCadastroPF;
	}

}
