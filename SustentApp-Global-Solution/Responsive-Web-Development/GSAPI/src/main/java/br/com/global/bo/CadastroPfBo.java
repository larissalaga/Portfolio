package br.com.global.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.CadastroPF;
import br.com.global.dao.CadastroPfDao;

public class CadastroPfBo {

	CadastroPfDao cadastroPfDao;

	public void inserirBo(CadastroPF cadastroPf) throws ClassNotFoundException, SQLException {
		cadastroPfDao = new CadastroPfDao();
		cadastroPfDao.inserir(cadastroPf);
	}

	public List<CadastroPF> visualizarBo() throws ClassNotFoundException, SQLException {
		cadastroPfDao = new CadastroPfDao();
		return (ArrayList<CadastroPF>) cadastroPfDao.visualizar();
	}

}
