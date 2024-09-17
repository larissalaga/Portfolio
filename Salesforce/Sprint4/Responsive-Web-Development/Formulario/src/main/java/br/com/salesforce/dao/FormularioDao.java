package br.com.salesforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesforce.beans.Formulario;
import br.com.salesforce.conexoes.ConnectionFactory;

public class FormularioDao {
	
	public Connection minhaconexao;

	public FormularioDao() throws ClassNotFoundException, SQLException {
		super();
		this.minhaconexao = new ConnectionFactory().conexao();
		
	}
	
	public String inserir(Formulario formulario) throws SQLException {
		PreparedStatement stmt = minhaconexao.prepareStatement("insert into formulario values(?,?,?,?,?)");
		
		stmt.setString(1, formulario.getNome());
		stmt.setString(2, formulario.getEmail());
		stmt.setString(3, formulario.getTelefone());
		stmt.setString(4, formulario.getEmpresa());
		stmt.setString(5, formulario.getRegiao());
		stmt.execute();
		stmt.close();
		
		return null;
	}
	
	public List<Formulario> visualizar() throws SQLException{
		List<Formulario> listaFormulario = new ArrayList<Formulario>();
		PreparedStatement stmt = minhaconexao.prepareStatement("select * from formulario");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Formulario forms = new Formulario();
			forms.setNome(rs.getString(1));
			forms.setEmail(rs.getString(2));
			forms.setTelefone(rs.getString(3));
			forms.setEmpresa(rs.getString(4));
			forms.setRegiao(rs.getString(5));
			listaFormulario.add(forms);
			
		}
		return listaFormulario;
	}
	
}
