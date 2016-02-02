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
import br.com.l0k0s.portal.interfaces.repositorio.StatusUsuarioRepositorio;
import br.com.l0k0s.portal.model.StatusUsuario;
import br.com.l0k0s.portal.validation.StatusUsuarioValidator;

@Controller
public class StatusUsuarioController {

	private StatusUsuarioRepositorio statusUsuarioRepositorio;
	private Result result;
	private StatusUsuarioValidator StatusUsuarioValidator;

	@Deprecated
	public StatusUsuarioController() {
	}

	@Inject
	public StatusUsuarioController(StatusUsuarioRepositorio statusUsuarioRepositorio, Result result,
			StatusUsuarioValidator statusUsuarioValidator) {
		this.statusUsuarioRepositorio = statusUsuarioRepositorio;
		this.result = result;
		this.StatusUsuarioValidator = statusUsuarioValidator;
	}

	@Get("/statusUsuarios")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(statusUsuarioRepositorio.listAll()).serialize();
	}

	@Post("/statusUsuarios")
	@Consumes("application/json")
	public void salva(StatusUsuario statusUsuario) {
		StatusUsuarioValidator.validate(statusUsuario);
		statusUsuarioRepositorio.guarda(statusUsuario);
	}

	@Delete(("/statusUsuarios/{id}"))
	public void deleta(@Valid long id) {
		statusUsuarioRepositorio.retira(id);
	}

}
