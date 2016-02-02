package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.SetorDao;
import br.com.l0k0s.portal.interfaces.repositorio.SetorRepositorio;
import br.com.l0k0s.portal.model.Setor;

public class SetorRepositorioDao implements SetorRepositorio {
	
	private final SetorDao setorDao;
	
	@Deprecated
	public SetorRepositorioDao() {
		this(null);
	}
	
	@Inject
	public SetorRepositorioDao(SetorDao setorDao) {
		this.setorDao = setorDao;
	}
	
	@Override
	public void guarda(Setor setor) {
		setorDao.save(setor);
	}

	@Override
	public List<Setor> listAll() {
		return setorDao.listAll();
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifica(Setor objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Setor verificaSeExiste(Setor setor) {		
		return setorDao.checkIfThere(setor);
	}

}
