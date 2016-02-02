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
import br.com.l0k0s.portal.interfaces.repositorio.StatusAssinantePlanoRepositorio;
import br.com.l0k0s.portal.model.StatusAssinantePlano;

@Controller
public class StatusAssinantePlanoController {

	private StatusAssinantePlanoRepositorio statusAssinantePlanoRepositorio;
	private Result result;

	@Deprecated
	public StatusAssinantePlanoController() {
	}

	@Inject
	public StatusAssinantePlanoController(StatusAssinantePlanoRepositorio statusAssinantePlanoRepositorio,
			Result result) {
		this.statusAssinantePlanoRepositorio = statusAssinantePlanoRepositorio;		
		this.result = result;
	}

	@Post("/statusAssinantePlanos")
	@Consumes("application/json")
	public void save(StatusAssinantePlano statusPlanoAssinante) {
		statusAssinantePlanoRepositorio.guarda(statusPlanoAssinante);
	}

	@Get("/statusAssinantePlanos")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(statusAssinantePlanoRepositorio.listAll()).serialize();
	}

	@Delete("/statusAssinantePlano/{id}")
	@Consumes("application/json")
	public void delete(@Valid long id) {
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401, "Não é possivel excluir");;
		statusAssinantePlanoRepositorio.retira(id);
	}	
}
