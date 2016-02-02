package br.com.l0k0s.portal.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.annotation.Adm;
import br.com.l0k0s.portal.interfaces.repositorio.ServicoRepositorio;
import br.com.l0k0s.portal.model.Servico;
import br.com.l0k0s.portal.validation.ServicoValidator;

@Adm
@Controller
public class ServicoController {

	private ServicoRepositorio servicoRepositorio;
	private Result result;
	private ServicoValidator validator;

	@Deprecated
	public ServicoController() {
	}

	@Inject
	public ServicoController(ServicoRepositorio servicoRepositorio, Result result, ServicoValidator validator) {
		this.servicoRepositorio = servicoRepositorio;
		this.result = result;
		this.validator = validator;
	}

	/**
	 * Valid utilizado para validar o Servico
	 */
	@Post("/servicos")
	@Consumes("application/json")
	public void salva(Servico servico) {
		validator.validate(servico);
		servicoRepositorio.guarda(servico);
	}

	/**
	 * Lista todos os serviços
	 */
	@Get("/servicos")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(servicoRepositorio.listAll()).serialize();
	}

	@Delete("/servicos/{id}")
	public void deleta(@Valid long id) {
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401,
				"Não é possivel excluir");
		servicoRepositorio.retira(id);
	}

}
