package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesfoce.beans.Endereco;
import br.com.salesforce.conexoes.ConnectionFactory;

public class EnderecoDao {

	public Connection minhaConexao;

	public EnderecoDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConnectionFactory().conexao();
	}
	
	public String inserir(Endereco endereco) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("insert into T_SGDD_ENDERECO values(?,?,?,?,?,?,?,?)");
		
		stmt.setString(1, endereco.getCep());
		stmt.setString(2, endereco.getLogradouro());
		stmt.setInt(3, endereco.getNum());
		stmt.setString(4, endereco.getComplemento());
		stmt.setString(5, endereco.getCidade());
		stmt.setString(6, endereco.getEstado());
		stmt.setString(7, endereco.getPais());
		stmt.setInt(8, endereco.getId());
		stmt.execute();
		stmt.close();
		
		return "Endereço cadastrado com sucesso!";
	}
	
	public List<Endereco> visualizar() throws SQLException{
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_SGDD_ENDERECO");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Endereco endereco = new Endereco();
			endereco.setCep(rs.getString(1));
			endereco.setLogradouro(rs.getString(2));
			endereco.setNum(rs.getInt(3));
			endereco.setComplemento(rs.getString(4));
			endereco.setCidade(rs.getString(5));
			endereco.setEstado(rs.getString(6));
			endereco.setPais(rs.getString(7));
			endereco.setId(rs.getInt(8));
			listaEndereco.add(endereco);
			
		}
		
		
		return listaEndereco;
	}
	
	
}
