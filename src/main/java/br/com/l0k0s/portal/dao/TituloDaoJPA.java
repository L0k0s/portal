package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.TituloDao;
import br.com.l0k0s.portal.model.Titulo;

@Transactional
public class TituloDaoJPA implements TituloDao {

	private EntityManager manager;

	@Deprecated
	public TituloDaoJPA() {
	}

	@Inject
	public TituloDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Titulo titulo) {

		manager.persist(titulo);
	}

	@Override
	public List<Titulo> listAll() {

		return manager.createQuery("select t from Titulo t", Titulo.class).getResultList();
	}

	@Override
	public void delete(long id) {
		
		Titulo titulo = manager.find(Titulo.class, id);
		manager.remove(titulo);
	}

	@Override
	public void update(Titulo titulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Titulo checkIfThere(Titulo titulo) {
		try {
			return manager.createQuery("select t from Titulo t where t.nome = :nome", Titulo.class)
					.setParameter("nome", titulo.getNome()).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

}
