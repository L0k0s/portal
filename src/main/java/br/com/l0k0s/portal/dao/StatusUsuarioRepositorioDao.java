package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.StatusUsuarioDao;
import br.com.l0k0s.portal.interfaces.repositorio.StatusUsuarioRepositorio;
import br.com.l0k0s.portal.model.StatusUsuario;

public class StatusUsuarioRepositorioDao implements StatusUsuarioRepositorio {

	private final StatusUsuarioDao statusUsuarioDao;
	
	@Deprecated
	public StatusUsuarioRepositorioDao() {
		this(null);
	}
	
	@Inject
	public StatusUsuarioRepositorioDao(StatusUsuarioDao statusUsuarioDao) {
		this.statusUsuarioDao = statusUsuarioDao;
	}
	
	@Override
	public void guarda(StatusUsuario statusUsuario) {
		statusUsuarioDao.save(statusUsuario);

	}

	@Override
	public List<StatusUsuario> listAll() {		
		return statusUsuarioDao.listAll();
	}

	@Override
	public void retira(long id) {
		statusUsuarioDao.delete(id);
	}

	@Override
	public void modifica(StatusUsuario objeto) {

	}

	@Override
	public StatusUsuario verificaSeExiste(StatusUsuario statusUsuario) {
		return statusUsuarioDao.checkIfThere(statusUsuario);
	}

}
