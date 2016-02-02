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
import br.com.l0k0s.portal.interfaces.repositorio.CategoriaRepositorio;
import br.com.l0k0s.portal.model.Categoria;
import br.com.l0k0s.portal.validation.CategoriaValidator;

@Adm
@Controller
public class CategoriaController {

	private CategoriaRepositorio categoriaRepositorio;
	private Result result;
	private CategoriaValidator validator;

	@Deprecated
	protected CategoriaController() {
	}

	@Inject
	public CategoriaController(CategoriaRepositorio categoriaRepositorio, Result result, CategoriaValidator validator) {

		this.categoriaRepositorio = categoriaRepositorio;
		this.result = result;
		this.validator = validator;

	}

	@Post("/categorias")
	@Consumes("application/json")
	public void save(Categoria categoria) {
		validator.validate(categoria);
		categoriaRepositorio.guarda(categoria);
	}

	@Get("/categorias")
	public void listAll() {
		result.use(Results.json()).withoutRoot().from(categoriaRepositorio.listAll()).serialize();
	}

	@Delete("/categorias")
	@Consumes("application/json")
	public void deleta(@Valid long id) {
		result.on(org.hibernate.exception.ConstraintViolationException.class).use(Results.http()).sendError(401,
				"Não é possível excluir!");
		categoriaRepositorio.retira(id);
	}

}
