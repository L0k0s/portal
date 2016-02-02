package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.StatusAssinantePlanoRepositorio;
import br.com.l0k0s.portal.model.StatusAssinantePlano;

public class StatusAssinantePlanoValidator {

	private StatusAssinantePlanoRepositorio statusAssinantePlanoRepositorio;
	private Validator validator;

	@Deprecated
	public StatusAssinantePlanoValidator() {
	}

	@Inject
	public StatusAssinantePlanoValidator(StatusAssinantePlanoRepositorio statusAssinantePlanoRepositorio,
			Validator validator) {
		this.statusAssinantePlanoRepositorio = statusAssinantePlanoRepositorio;
		this.validator = validator;		
	}
	
	public void validate(StatusAssinantePlano statusAssinantePlano){
		
		validator.validate(statusAssinantePlano);
		
		if(statusAssinantePlanoRepositorio.verificaSeExiste(statusAssinantePlano) != null){
			validator.add(new I18nMessage("Status", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
	}

}
