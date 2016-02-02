package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.UsuarioDao;
import br.com.l0k0s.portal.model.Usuario;

@Transactional
public class UsuarioDaoJPA implements UsuarioDao {

	private EntityManager manager;

	@Deprecated
	public UsuarioDaoJPA() {
	}

	@Inject
	public UsuarioDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	@Override
	public List<Usuario> listAll() {
		return manager.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}

	@Override
	public void delete(long id) {
		Usuario usuario = manager.find(Usuario.class, id);
		manager.remove(usuario);
	}

	@Override
	public void update(Usuario usuarioModificado) {
		Usuario usuario = manager.find(Usuario.class, usuarioModificado.getId());
		usuario.setSetor(usuarioModificado.getSetor());
		usuario.setStatusUsuario(usuarioModificado.getStatusUsuario());		
	}

	@Override
	public Usuario findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> search(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario autentica(String nome, String senha) {

		try {
			return manager
					.createQuery(
							"select u from Usuario u where u.nome = :nome and u.senha = :senha",
							Usuario.class).setParameter("nome", nome)
					.setParameter("senha", senha).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Usuario checkIfThere(Usuario usuario) {
		return manager
				.createQuery("select u from Usuario where u.nome = nome",
						Usuario.class).setParameter("nome", usuario.getNome())
				.getSingleResult();
	}

}
