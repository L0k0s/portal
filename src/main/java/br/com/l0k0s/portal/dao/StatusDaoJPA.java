package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.StatusDao;
import br.com.l0k0s.portal.model.Status;

@Transactional
public class StatusDaoJPA implements StatusDao {

	private EntityManager manager;

	@Deprecated
	public StatusDaoJPA() {
	}

	@Inject
	public StatusDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Status status) {
		manager.persist(status);
	}

	@Override
	public List<Status> listAll() {
		return manager.createQuery("select s from Status s", Status.class).getResultList();
	}

	@Override
	public void delete(long id) {

		Status status = manager.find(Status.class, id);
		manager.remove(status);
	}

	@Override
	public void update(Status objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status checkIfThere(Status status) {
		try {
			return manager.createQuery("select s from Status s where s.nome = :nome", Status.class)
					.setParameter("nome", status.getNome()).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
