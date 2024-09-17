package br.com.global.bo;

import java.util.ArrayList;
import java.util.List;

import br.com.global.beans.CadastroPJ;
import br.com.global.dao.CadastroPjDao;

public class CadastroPjBo {

    CadastroPjDao cadastroPjDao;

    public void inserirBo(CadastroPJ cadastroPj) {
        cadastroPjDao = new CadastroPjDao();
		cadastroPjDao.inserir(cadastroPj);
    }

    public List<CadastroPJ> visualizarBo() {
        cadastroPjDao = new CadastroPjDao();
		return (ArrayList<CadastroPJ>) cadastroPjDao.visualizar();
    }
}
