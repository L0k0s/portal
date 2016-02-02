package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.annotation.Adm;
import br.com.l0k0s.portal.interfaces.repositorio.UsuarioRepositorio;
import br.com.l0k0s.portal.model.Usuario;
import br.com.l0k0s.portal.validation.UsuarioValidator;

@Adm
@Controller
public class UsuarioController {
	
	private UsuarioRepositorio usuarioRepositorio;
	private Result result;
	private UsuarioValidator usuarioValidator;
	
	@Deprecated	
	public UsuarioController() {}
	
	@Inject
	public UsuarioController(UsuarioRepositorio usuarioRepositorio, Result result, UsuarioValidator usuarioValidator){
		this.usuarioRepositorio = usuarioRepositorio;
		this.result = result;
		this.usuarioValidator = usuarioValidator;
	}
	
	@Post("/usuarios")
	@Consumes("application/json")
	public void salva(Usuario usuario){
		usuarioValidator.validate(usuario);
		usuarioRepositorio.guarda(usuario);
	}

	@Get("/usuarios")
	public void lista(){
		result.use(Results.json()).withoutRoot().from(usuarioRepositorio.listAll()).
		exclude("senha").
		include("setor").serialize();
	}
	
	@Post
	@Consumes("application/json")
	public void modifica(Usuario usuario){
		usuarioRepositorio.modifica(usuario);
	}
	
}
