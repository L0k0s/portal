package br.com.l0k0s.portal.interfaces.repositorio;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Usuario;

public interface UsuarioRepositorio extends InterfaceGenericRepositorio<Usuario> {
	
	public Usuario procuraPorId(long id);
	
	public List<Usuario> procuraPorNome(String nome);
	
	public Usuario comLoginESenha(String nome, String senha);
}
