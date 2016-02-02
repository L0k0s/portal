package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.StatusAssinantePlanoDao;
import br.com.l0k0s.portal.model.StatusAssinantePlano;

@Transactional
public class StatusAssinantePlanoDaoJPA implements StatusAssinantePlanoDao {

	private EntityManager manager;

	@Deprecated
	public StatusAssinantePlanoDaoJPA() {
	}

	@Inject
	public StatusAssinantePlanoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(StatusAssinantePlano statusPlanoAssinante) {
		manager.persist(statusPlanoAssinante);
	}

	@Override
	public List<StatusAssinantePlano> listAll() {
		return manager.createQuery("select s from StatusAssinantePlano s", StatusAssinantePlano.class).getResultList();
	}

	@Override
	public void delete(long id) {
		StatusAssinantePlano statusAssinantePlano = manager.find(StatusAssinantePlano.class, id);
		manager.remove(statusAssinantePlano);
	}

	@Override
	public void update(StatusAssinantePlano objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public StatusAssinantePlano checkIfThere(StatusAssinantePlano statusPlanoAssinante) {
		return manager
				.createQuery("select s from StatusAssinantePlano s where s.nome = nome", StatusAssinantePlano.class)
				.setParameter("nome", statusPlanoAssinante.getNome()).getSingleResult();
	}

}
