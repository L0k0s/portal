package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.StatusAssinantePlanoDao;
import br.com.l0k0s.portal.interfaces.repositorio.StatusAssinantePlanoRepositorio;
import br.com.l0k0s.portal.model.StatusAssinantePlano;

public class StatusAssinantePlanoRepositorioDao implements StatusAssinantePlanoRepositorio {

	private final StatusAssinantePlanoDao statusAssinantePlanoDao;
	
	@Deprecated
	public StatusAssinantePlanoRepositorioDao() {
		this(null);
	}
	
	@Inject
	public StatusAssinantePlanoRepositorioDao(StatusAssinantePlanoDao statusAssinantePlanoDao){
		this.statusAssinantePlanoDao = statusAssinantePlanoDao;
	}

	@Override
	public void guarda(StatusAssinantePlano statusPlanoAssinante) {
		statusAssinantePlanoDao.save(statusPlanoAssinante);	
	}

	@Override
	public List<StatusAssinantePlano> listAll() {		
		return statusAssinantePlanoDao.listAll();
	}

	@Override
	public void retira(long id) {
		statusAssinantePlanoDao.delete(id);
	}

	@Override
	public void modifica(StatusAssinantePlano objeto) {
		
	}

	@Override
	public StatusAssinantePlano verificaSeExiste(StatusAssinantePlano statusPlanoAssinante) {
		return statusAssinantePlanoDao.checkIfThere(statusPlanoAssinante);
	}
	
}
