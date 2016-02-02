package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.UsuarioRepositorio;
import br.com.l0k0s.portal.model.Usuario;

public class UsuarioValidator {
	
	private Validator validator;
	private UsuarioRepositorio usuarioRepositorio;
	
	@Deprecated
	public UsuarioValidator() {}
	
	@Inject
	public UsuarioValidator(Validator validator, UsuarioRepositorio usuarioRepositorio){
		this.validator = validator;
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	public void validate(Usuario usuario){
		
		Usuario usuarioV  = usuarioRepositorio.verificaSeExiste(usuario);
				
		if(usuarioV != null){
			validator.add(new I18nMessage("Login", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}	
		
	}
}
