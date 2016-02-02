package br.com.l0k0s.portal.controller;

import java.util.List;

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
import br.com.l0k0s.portal.interfaces.repositorio.TituloRepositorio;
import br.com.l0k0s.portal.model.Titulo;
import br.com.l0k0s.portal.validation.TituloValidator;

@Adm
@Controller
public class TituloController {

	private TituloRepositorio tituloRepositorio;
	private Result result;
	private TituloValidator tituloValidator;

	@Deprecated
	public TituloController() {
	}

	@Inject
	public TituloController(TituloRepositorio tituloRepositorio, Result result, TituloValidator tituloValidator) {
		this.tituloRepositorio = tituloRepositorio;
		this.result = result;
		this.tituloValidator = tituloValidator;
	}

	@Post("/titulos")
	@Consumes("application/json")
	public void salva(Titulo titulo) {
		tituloValidator.validate(titulo);
		tituloRepositorio.guarda(titulo);
	}

	@Get("/titulos")
	public void listAll() {
		List<Titulo> listaAll = tituloRepositorio.listAll();
		result.use(Results.json()).withoutRoot().from(listaAll).include("servico").serialize();
	}

	@Delete("/titulos/{id}")
	@Consumes("application/json")
	public void deleta(@Valid long id) {
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401,
				"Não é possível excluir!");
		tituloRepositorio.retira(id);
	}

}
