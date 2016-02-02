package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.ChamadoRepositorio;
import br.com.l0k0s.portal.model.Chamado;
import br.com.l0k0s.portal.model.UsuarioLogado;
import br.com.l0k0s.portal.validation.ChamadoValidator;

@Controller

public class ChamadoController {

	private ChamadoRepositorio chamadoRepositorio;
	private Result result;
	private ChamadoValidator chamadoValidator;

	@Deprecated
	protected ChamadoController() {
	}

	@Inject
	public ChamadoController(ChamadoRepositorio chamadoRepositorio, Result result, ChamadoValidator chamadoValidator) {
		this.chamadoRepositorio = chamadoRepositorio;
		this.result = result;
		this.chamadoValidator = chamadoValidator;
	}

	@Post("/chamados")
	@Consumes("application/json")
	public void salva(Chamado chamado) {
		chamadoValidator.validator(chamado);
 		chamado.getListaHistoricoChamados().get(0).getUsuario().setId(UsuarioLogado.usuarioDTO.getUsuarioId());
		chamadoRepositorio.guarda(chamado);
	}

	@Get("/chamados")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(chamadoRepositorio.searchCalledOpen()).exclude("dataAberturaSemFormato").serialize();
	}

	@Get("/chamados/count")
	public void count() {
		result.use(Results.json()).withoutRoot().from(chamadoRepositorio.ConutBySetor()).serialize();
	}

}
