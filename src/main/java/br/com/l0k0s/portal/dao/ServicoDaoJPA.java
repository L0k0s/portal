package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.ServicoDao;
import br.com.l0k0s.portal.model.Servico;

/*
 * Autor: Alexandre
 * Classe utilizada para inserir no Banco de Dados via JPA.
 */

@Transactional
public class ServicoDaoJPA implements ServicoDao {

	private EntityManager manager;

	@Deprecated
	protected ServicoDaoJPA() {

	}

	@Inject
	public ServicoDaoJPA(EntityManager manager) {

		this.manager = manager;

	}

	@Override
	public void save(Servico servico) {
		manager.persist(servico);
	}

	@Override
	public List<Servico> listAll() {

		return manager.createQuery("select s from Servico s", Servico.class).getResultList();

	}

	@Override
	public void delete(long id) {

		Servico servico = manager.find(Servico.class, id);
		manager.remove(servico);
	}

	@Override
	public void update(Servico objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Servico checkIfThere(Servico servico) {

		try {
			return manager.createQuery("select s from Servico s where s.nome = :nome", Servico.class)
					.setParameter("nome", servico.getNome()).getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

}
