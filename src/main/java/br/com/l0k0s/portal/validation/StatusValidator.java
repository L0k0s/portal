package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.StatusRepositorio;
import br.com.l0k0s.portal.model.Status;

public class StatusValidator {

	private Validator validator;
	private StatusRepositorio statusRepositorio;

	@Deprecated
	public StatusValidator() {
	}

	@Inject
	public StatusValidator(Validator validator, StatusRepositorio statusRepositorio) {
		this.validator = validator;
		this.statusRepositorio = statusRepositorio;
	}

	public void validate(Status status) {

		Status statusV = statusRepositorio.verificaSeExiste(status);

		if (statusV != null) {
			validator.add(new I18nMessage("Status", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}

	}
}
