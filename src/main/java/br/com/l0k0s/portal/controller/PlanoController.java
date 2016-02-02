package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.annotation.Adm;
import br.com.l0k0s.portal.interfaces.repositorio.PlanoRepositorio;
import br.com.l0k0s.portal.model.Plano;
import br.com.l0k0s.portal.validation.PlanoValidator;

@Adm
@Controller
public class PlanoController {

	private PlanoRepositorio planoRepositorio;
	private Result result;
	private PlanoValidator validator;

	@Deprecated
	protected PlanoController() {

	}

	@Inject
	public PlanoController(PlanoRepositorio planoRepositorio, Result result, PlanoValidator validator) {
		this.validator = validator;
		this.planoRepositorio = planoRepositorio;
		this.result = result;
	}

	@Post("/planos")
	@Consumes("application/json")
	public void salva(Plano plano) {
		validator.validate(plano);
		planoRepositorio.guarda(plano);
	}

	/*
	 * Utilizando o include visto que para adicionar lists ou objs que são
	 * atributos de outro obj é necessário utilizar.
	 */
	@Get("/planos")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(planoRepositorio.listAll()).include("categoria", "servico")
				.serialize();
	}

	@Put("/planos/{id}")
	@Consumes("application/json")
	public void altera(Plano plano) {
		planoRepositorio.modifica(plano);
		result.use(Results.json()).withoutRoot().from(plano).include("categoria", "servico")
				.serialize();
	}

	@Delete("/planos/{id}")
	@Consumes("application/json")
	public void deleta(long id) {
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401,
				"Não é possível excluir!");
		planoRepositorio.retira(id);
	}		
}
