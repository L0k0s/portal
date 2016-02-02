package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.SetorDao;
import br.com.l0k0s.portal.model.Setor;

@Transactional
public class SetorDaoJPA implements SetorDao {

	private EntityManager manager;

	@Deprecated
	public SetorDaoJPA() {
	}

	@Inject
	public SetorDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Setor setor) {
		manager.persist(setor);
	}

	@Override
	public List<Setor> listAll() {

		return manager.createQuery("select s from Setor s", Setor.class).getResultList();
	}

	@Override
	public void delete(long id) {

		Setor setor = manager.find(Setor.class, id);
		manager.remove(setor);
	}

	@Override
	public void update(Setor objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Setor checkIfThere(Setor setor) {
		return manager.createQuery("select s from Setor s where s.nome = nome", Setor.class)
				.setParameter("nome", setor.getNome()).getSingleResult();
	}

}
