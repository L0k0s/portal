package br.com.l0k0s.portal.model;

import javax.enterprise.context.RequestScoped;

import br.com.l0k0s.portal.dto.UsuarioDTO;

@RequestScoped
public class UsuarioLogado{

	public static UsuarioDTO usuarioDTO;
}
