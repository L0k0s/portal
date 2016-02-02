package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.HistoricoChamadoRepositorio;
import br.com.l0k0s.portal.model.HistoricoChamado;
import br.com.l0k0s.portal.model.UsuarioLogado;

@Controller
public class HistoricoChamadoController {
	
	private HistoricoChamadoRepositorio historicoChamadoRepositorio;
	private Result result;
	
	@Deprecated
	public HistoricoChamadoController() {}
	
	@Inject
	public HistoricoChamadoController(HistoricoChamadoRepositorio historicoChamadoRepositorio, Result result){
		this.historicoChamadoRepositorio = historicoChamadoRepositorio;
		this.result = result;
	}
	
	@Post("/historicos")
	@Consumes
	public void salva(HistoricoChamado historicoChamado){
		historicoChamado.getUsuario().setId(UsuarioLogado.usuarioDTO.getUsuarioId());
		historicoChamado.getUsuario().setNome((UsuarioLogado.usuarioDTO.getUsuarioNome()));
		historicoChamadoRepositorio.guarda(historicoChamado);
		result.use(Results.json()).withoutRoot().from(historicoChamado).include("usuario", "setor", "status").serialize();
	}
	
	@Get("/historicos/{id}")
	public void lista(long id){		
		result.use(Results.json()).withoutRoot().from(historicoChamadoRepositorio.listaHistoricos(id)).include("status","usuario","setor", "chamado", "chamado.titulo", "chamado.titulo.servico").exclude("usuario.senha").serialize();
	}
}
