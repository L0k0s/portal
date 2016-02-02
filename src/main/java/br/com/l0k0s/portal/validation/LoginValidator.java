package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.dto.UsuarioDTO;
import br.com.l0k0s.portal.interfaces.repositorio.UsuarioRepositorio;
import br.com.l0k0s.portal.model.Usuario;
import br.com.l0k0s.portal.model.UsuarioLogado;
import br.com.l0k0s.portal.ultils.JWTToken;

public class LoginValidator {

	//private UsuarioLogado usuarioLogado;
	private UsuarioRepositorio usuarioRepositorio;
	private Result result;
	private Validator validator;

	@Deprecated
	public LoginValidator() {
	}

	@Inject
	public LoginValidator(UsuarioLogado usuarioLogado, UsuarioRepositorio usuarioRepositorio, Result result,
			Validator validator) {
		//this.usuarioLogado = usuarioLogado;
		this.usuarioRepositorio = usuarioRepositorio;
		this.result = result;
		this.validator = validator;
		
	}

	/*
	 * Validator se usar brutauth public Result validate(String login, String
	 * senha){
	 * 
	 * Usuario usuario = usuarioRepositorio.comLoginESenha(login, senha);
	 * 
	 * if(usuario != null){ usuarioLogado.loga(usuario);
	 * result.use(Results.http()).setStatusCode(200); }else{
	 * result.use(Results.http()).setStatusCode(401); } return result; }
	 */

	public Result validate(String login, String senha) {

		Usuario usuario = usuarioRepositorio.comLoginESenha(login, senha);				
		if (usuario != null){
			result.use(Results.http()).addHeader("Authorization", JWTToken.createToken(usuario.getId()));
			result.use(Results.http()).setStatusCode(200);
		} else {
			result.use(Results.http()).setStatusCode(401);
			validator.add(new I18nMessage("Login", "objeto.invalido"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
		return result;
	}

	public Result validate2(String login, String senha) {

		Usuario usuario = usuarioRepositorio.comLoginESenha(login, senha);				
			
		if (usuario != null){
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getSetor().getNome());
			result.use(Results.http()).addHeader("Authorization", JWTToken.createToken2(usuarioDTO));
			result.use(Results.http()).setStatusCode(200);
		} else {
			result.use(Results.http()).setStatusCode(401);
			validator.add(new I18nMessage("Login", "objeto.invalido"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
		return result;
	}
	
}
