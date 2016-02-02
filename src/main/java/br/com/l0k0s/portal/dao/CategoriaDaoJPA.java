package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.CategoriaDao;
import br.com.l0k0s.portal.model.Categoria;

/*
 * Autor: Alexandre
 * Classe utilizada para inserir no Banco de Dados via JPA.
 */

@Transactional
public class CategoriaDaoJPA implements CategoriaDao {

	private EntityManager manager;

	@Deprecated
	public CategoriaDaoJPA() {

	}

	@Inject
	public CategoriaDaoJPA(EntityManager manager) {

		this.manager = manager;

	}

	@Override
	public void save(Categoria categoria) {
		manager.persist(categoria);
	}

	@Override
	public List<Categoria> listAll() {

		return manager.createQuery("select c from Categoria c", Categoria.class).getResultList();
	}

	@Override
	public void delete(long id) {
		Categoria categoria = manager.find(Categoria.class, id);
		manager.remove(categoria);
	}

	@Override
	@Deprecated
	public void update(Categoria categoria) {
	}

	@Override
	public Categoria checkIfThere(Categoria categoria) {
		try {
			return manager.createQuery("select c from Categoria c where c.nome = :nome", Categoria.class)
					.setParameter("nome", categoria.getNome()).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
