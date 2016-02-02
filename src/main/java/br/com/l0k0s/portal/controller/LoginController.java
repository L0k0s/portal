package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.l0k0s.portal.interfaces.repositorio.UsuarioRepositorio;
import br.com.l0k0s.portal.model.UsuarioLogado;
import br.com.l0k0s.portal.validation.LoginValidator;

@Controller
public class LoginController {
	
	//private UsuarioRepositorio usuariosepositorio;
	//private UsuarioLogado usuarioLogado;
	private Result result;
	private LoginValidator validator;
	
	@Deprecated
	public LoginController(){}
	
	@Inject
	public LoginController(UsuarioRepositorio usuarioRepositorio, UsuarioLogado usuarioLogado, Result result, LoginValidator validator){
		//this.usuariosepositorio = usuarioRepositorio;
		//this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}
	
	@Get("/login")
	public void login(){
		result.of(this).login();
	}
	
	@Post("/login")
	@Consumes("application/json")
	public void login(String login, String senha){
		validator.validate2(login, senha);		
	}
	
	/*
	@Get("/logout")
	public void logout(){
		usuarioLogado.desloga();
		//verificar com o thiniel redirecionamento para o angular		
	}
	
	@Get("/isLogged")
	public boolean isLogged(){
		return usuarioLogado.isLogado();
	}
	  */             
	
}
