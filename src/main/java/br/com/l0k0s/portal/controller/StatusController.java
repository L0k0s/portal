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
import br.com.l0k0s.portal.interfaces.repositorio.StatusRepositorio;
import br.com.l0k0s.portal.model.Status;
import br.com.l0k0s.portal.validation.StatusValidator;

@Adm
@Controller
public class StatusController {
	
	private StatusRepositorio statusRepositorio;
	private Result result;
	private StatusValidator statusValidator;
	
	@Deprecated
	public StatusController() {}
	
	@Inject
	public StatusController(StatusRepositorio statusRepositorio, Result result, StatusValidator statusValidator) {
		this.statusRepositorio = statusRepositorio;
		this.result = result;
		this.statusValidator = statusValidator;
	}
	
	@Post("/status")
	@Consumes("application/json")
	public void salva(Status status){
		statusValidator.validate(status);
		statusRepositorio.guarda(status);
	}
	
	@Get("/status")
	public void lista(){
		result.use(Results.json()).withoutRoot().from(statusRepositorio.listAll()).serialize();
	}
	
	@Delete("/status/{id}")
	@Consumes("application/json")
	public void delete(@Valid long id){
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401,
				"Não é possível excluir!");
		statusRepositorio.retira(id);
	}
	
	
}
