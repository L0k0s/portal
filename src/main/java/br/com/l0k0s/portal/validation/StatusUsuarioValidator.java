package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.StatusUsuarioRepositorio;
import br.com.l0k0s.portal.model.StatusUsuario;

public class StatusUsuarioValidator {
	private Validator validator;
	private StatusUsuarioRepositorio statusUsuarioRepositorio;

	@Deprecated
	public StatusUsuarioValidator() {
	}

	@Inject
	public StatusUsuarioValidator(Validator validator, StatusUsuarioRepositorio statusUsuarioRepositorio) {
		this.validator = validator;
		this.statusUsuarioRepositorio = statusUsuarioRepositorio;
	}

	public void validate(StatusUsuario statusUsuario) {

		StatusUsuario statusV = statusUsuarioRepositorio.verificaSeExiste(statusUsuario);

		if (statusV != null) {
			validator.add(new I18nMessage("Status Usuário", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}

	}
}


