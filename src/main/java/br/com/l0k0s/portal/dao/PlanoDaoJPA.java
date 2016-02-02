package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.PlanoDao;
import br.com.l0k0s.portal.model.Plano;

@Transactional
public class PlanoDaoJPA implements PlanoDao {

	private EntityManager manager;

	@Deprecated
	public PlanoDaoJPA() {

	}

	@Inject
	public PlanoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Plano plano) {

		manager.persist(plano);

	}

	@Override
	public List<Plano> listAll() {

		return manager.createQuery("select p from Plano p", Plano.class).getResultList();

	}

	@Override
	public List<Plano> search(String nome) {

		return manager.createQuery("select p from Plano p where p.nome = :nome", Plano.class).setParameter("nome", nome)
				.getResultList();

	}

	@Override
	public void update(Plano planoUpdate) {
		Plano plano = this.findById(planoUpdate.getId());
		plano.setNome(planoUpdate.getNome());
		plano.setPreco(planoUpdate.getPreco());
	}

	@Override
	public void delete(long id) {

		Plano plano = manager.find(Plano.class, id);
		manager.remove(plano);
	}

	@Override
	public Plano findById(long id) {

		return manager.find(Plano.class, id);
	}

	@Override
	public Plano checkIfThere(Plano plano) {
		try {
			return manager
					.createQuery("select p from Plano p where p.nome = :nome "
							+ "and p.categoria.id = :categoriaId and p.servico.id = :servicoId", Plano.class)
					.setParameter("nome", plano.getNome()).setParameter("categoriaId", plano.getCategoria().getId())
					.setParameter("servicoId", plano.getServico().getId()).getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

}
