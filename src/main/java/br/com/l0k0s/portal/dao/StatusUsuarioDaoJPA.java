package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.StatusUsuarioDao;
import br.com.l0k0s.portal.model.StatusUsuario;

@Transactional
public class StatusUsuarioDaoJPA implements StatusUsuarioDao {

	private EntityManager manager;

	@Deprecated
	public StatusUsuarioDaoJPA() {
	}

	@Inject
	public StatusUsuarioDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(StatusUsuario statusUsuario) {
		manager.persist(statusUsuario);
	}

	@Override
	public List<StatusUsuario> listAll() {
		return manager.createQuery("select su from StatusUsuario su", StatusUsuario.class).getResultList();
	}

	@Override
	public void delete(long id) {
		StatusUsuario statusUsuario = manager.find(StatusUsuario.class, id);
		manager.remove(statusUsuario);
	}

	@Override
	public void update(StatusUsuario statusUsuarioModificado) {

	}

	@Override
	public StatusUsuario checkIfThere(StatusUsuario statusUsuario) {
		try {
			return manager.createQuery("select s from StatusUsuario s where s.nome = :nome", StatusUsuario.class)
					.setParameter("nome", statusUsuario.getNome()).getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
