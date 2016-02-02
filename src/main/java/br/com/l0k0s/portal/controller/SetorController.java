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
import br.com.l0k0s.portal.interfaces.repositorio.SetorRepositorio;
import br.com.l0k0s.portal.model.Setor;
import br.com.l0k0s.portal.validation.SetorValidator;
@Adm
@Controller
public class SetorController {
	
	private SetorRepositorio setorRepositorio;
	private Result result;
	private SetorValidator setorValidator;
	
	@Deprecated
	public SetorController() {}
	
	@Inject
	public SetorController(SetorRepositorio setorRepositorio, Result result, SetorValidator setorValidator){		
		this.setorRepositorio = setorRepositorio;
		this.result = result;		
		this.setorValidator = setorValidator;
	}
	
	@Post("/setores")
	@Consumes("application/json")
	public void salva(Setor setor){
		setorValidator.validate(setor);
		setorRepositorio.guarda(setor);
	}
	
	@Get("/setores")
	public void lista(){
		result.use(Results.json()).withoutRoot().from(setorRepositorio.listAll()).serialize();;
	}
	
	@Delete("/setores")
	@Consumes("application/json")
	public void delete(@Valid long id){
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401, "Não é possivel excluir");;
		setorRepositorio.retira(id);
	}
}
