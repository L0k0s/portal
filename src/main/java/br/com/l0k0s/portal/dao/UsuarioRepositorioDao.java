package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.UsuarioDao;
import br.com.l0k0s.portal.interfaces.repositorio.UsuarioRepositorio;
import br.com.l0k0s.portal.model.Usuario;

public class UsuarioRepositorioDao implements UsuarioRepositorio {
		
	private UsuarioDao usuarioDao; 
	
	@Deprecated
	public UsuarioRepositorioDao() {
		this(null);
	}
	
	@Inject
	public UsuarioRepositorioDao (UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	} 
	
	@Override
	public void guarda(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	public List<Usuario> listAll() {
		return usuarioDao.listAll();
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifica(Usuario usuario) {
		usuarioDao.update(usuario);

	}

	@Override
	public Usuario procuraPorId(long id) {
		return usuarioDao.findById(id);
	}

	@Override
	public List<Usuario> procuraPorNome(String nome) {
		return usuarioDao.search(nome);
	}

	@Override
	public Usuario comLoginESenha(String nome, String senha) {
		return usuarioDao.autentica(nome, senha);
	}

	@Override
	public Usuario verificaSeExiste(Usuario usuario) {		
		return usuarioDao.checkIfThere(usuario);
	}

}
