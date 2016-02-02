package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Usuario;

public interface UsuarioDao extends InterfaceGenericDao<Usuario> {
	
	public Usuario findById(long id);
	
	public List<Usuario> search(String nome);
	
	public Usuario autentica(String nome, String senha);
}
