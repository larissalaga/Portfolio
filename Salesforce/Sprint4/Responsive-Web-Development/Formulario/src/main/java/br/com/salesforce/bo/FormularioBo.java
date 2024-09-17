package br.com.salesforce.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.salesforce.beans.Formulario;
import br.com.salesforce.dao.FormularioDao;

public class FormularioBo {
	
	FormularioDao formularioDao;
	
	public void inserirBo(Formulario formulario) throws ClassNotFoundException, SQLException {
		formularioDao = new FormularioDao();
		formularioDao.inserir(formulario);
		
	}
	
	public List<Formulario> visualizarBo() throws ClassNotFoundException, SQLException {
		formularioDao = new FormularioDao();
		return (ArrayList<Formulario>) formularioDao.visualizar();
	}

}
