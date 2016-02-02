package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.ServicoRepositorio;
import br.com.l0k0s.portal.model.Servico;

/*
 * Autor: Alexandre
 * Classe utilizada para validar o Serviço seja no banco de dados ou outra
 * validação que não é possivel ser efetuada pelo beans validation
 */

public class ServicoValidator {

	private Validator validator;
	private ServicoRepositorio servicoRepositorio;

	@Deprecated
	protected ServicoValidator() {

	}

	@Inject
	public ServicoValidator(Validator validator, ServicoRepositorio servicoRepositorio) {

		this.validator = validator;
		this.servicoRepositorio = servicoRepositorio;
	}

	public void validate(Servico servico) {

		validator.validate(servico);

		Servico servicoV = servicoRepositorio.verificaSeExiste(servico);

		if (servicoV != null) {
			validator.add(new I18nMessage("Serviço", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}

	}

}
