package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.model.Chamado;

public class ChamadoValidator {
	
	private Validator validator;
	
	@Deprecated
	protected ChamadoValidator() {}
	
	@Inject
	public ChamadoValidator(Validator validator){
		this.validator = validator;
	}
	
	public void validator(Chamado chamado){
		validator.validate(chamado);
		validator.add(new SimpleMessage("Chamando", "objeto.existente"));
		validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
	}
}
