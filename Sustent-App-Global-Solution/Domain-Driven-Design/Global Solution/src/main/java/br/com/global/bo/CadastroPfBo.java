package br.com.global.bo;

import java.util.ArrayList;
import java.util.List;
import br.com.global.beans.CadastroPF;
import br.com.global.dao.CadastroPfDao;

public class CadastroPfBo {

    CadastroPfDao cadastroPfDao;

    public void inserirBo(CadastroPF cadastroPf) {
        cadastroPfDao = new CadastroPfDao();
		cadastroPfDao.inserir(cadastroPf);
    }

    public List<CadastroPF> visualizarBo() {
        cadastroPfDao = new CadastroPfDao();
		return (ArrayList<CadastroPF>) cadastroPfDao.visualizar();
    }
}