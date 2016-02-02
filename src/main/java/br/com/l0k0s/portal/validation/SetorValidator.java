package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.SetorRepositorio;
import br.com.l0k0s.portal.model.Setor;

public class SetorValidator {

	private Validator validator;
	private SetorRepositorio setorRepositorio;

	@Deprecated
	public SetorValidator() {
	}

	@Inject
	public SetorValidator(Validator validator, SetorRepositorio setorRepositorio) {
		this.validator = validator;
		this.setorRepositorio = setorRepositorio;
	}

	public void validate(Setor setor) {

		validator.validate(setor);
		Setor setorV = setorRepositorio.verificaSeExiste(setor);

		if (setorV != null) {
			validator.add(new I18nMessage("Setor", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
	}
}
