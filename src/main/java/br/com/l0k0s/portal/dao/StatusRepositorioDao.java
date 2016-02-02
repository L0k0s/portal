package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.StatusDao;
import br.com.l0k0s.portal.interfaces.repositorio.StatusRepositorio;
import br.com.l0k0s.portal.model.Status;

public class StatusRepositorioDao implements StatusRepositorio {
	
	private final StatusDao statusDao;
	
	@Deprecated
	public StatusRepositorioDao() {
		this(null);
	}
	
	@Inject
	public StatusRepositorioDao(StatusDao statusDao){
		this.statusDao = statusDao;
	}
	
	@Override
	public void guarda(Status status) {
		statusDao.save(status);
	}

	@Override
	public List<Status> listAll() {
		return statusDao.listAll();
	}

	@Override
	public void retira(long id) {
		statusDao.delete(id);
	}

	@Override
	public void modifica(Status status) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status verificaSeExiste(Status status) {
		return statusDao.checkIfThere(status);
	}

}
