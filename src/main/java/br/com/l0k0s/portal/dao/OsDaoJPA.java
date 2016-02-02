package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.l0k0s.portal.interfaces.dao.OsDao;
import br.com.l0k0s.portal.model.Os;

public class OsDaoJPA implements OsDao {

	private EntityManager manager;

	@Deprecated
	public OsDaoJPA() {
	}

	@Inject
	public OsDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Os os) {
		manager.persist(os);
	}

	@Override
	public List<Os> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Os os) {

	}

	@Override
	public Os findById(long id) {
		return null;
	}

	@Override
	public List<Os> listAll(long id) {
		return null;
	}

	@Override
	public Os checkIfThere(Os objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
