package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.AssinantePlanoDao;
import br.com.l0k0s.portal.interfaces.repositorio.AssinantePlanoRepositorio;
import br.com.l0k0s.portal.model.AssinantePlano;

public class AssinantePlanoRepositorioDao implements AssinantePlanoRepositorio {

	private final AssinantePlanoDao assinantePlanoDao;

	@Deprecated
	public AssinantePlanoRepositorioDao() {
		this(null);
	}

	@Inject
	public AssinantePlanoRepositorioDao(AssinantePlanoDao assinantePlanoDao) {
		this.assinantePlanoDao = assinantePlanoDao;
	}

	@Override
	public void guarda(AssinantePlano objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AssinantePlano> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retira(long objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifica(AssinantePlano assinantePlano) {
		assinantePlanoDao.update(assinantePlano);
	}

	@Override
	public AssinantePlano verificaSeExiste(AssinantePlano objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
