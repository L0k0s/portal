package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.AssinanteRepositorio;
import br.com.l0k0s.portal.model.Assinante;

@Controller
public class AssinanteController {

	private AssinanteRepositorio assinanteRepositorio;	
	private Result result;
	
	@Deprecated
	public AssinanteController() {
	}

	@Inject
	public AssinanteController(AssinanteRepositorio assinanteRepositorio, Result result) {
		this.assinanteRepositorio = assinanteRepositorio;
		this.result = result;		
	}

	@Post("/assinantes")
	@Consumes("application/json")
	public void salva(Assinante assinante){
		assinanteRepositorio.guarda(assinante);
	}

	@Get("/assinantes")
	public void busca(String nome) {
		result.use(Results.json()).withoutRoot().from(assinanteRepositorio.procuraPorNome(nome)).include("endereco")
				.serialize();
	}

	@Get("/assinantes/{id}")
	public void listaDetalhes(long id) {
		result.use(Results.json()).withoutRoot().from(assinanteRepositorio.procuraAssinantePorId(id))
				.include("endereco", "listaContatoAssinantes", "listaPlanos", "listaPlanos.statusAssinantePlano",
						"listaPlanos.plano", "listaPlanos.plano.categoria", "listaPlanos.plano.servico")
				.exclude("listaPlanos.plano.preco").serialize();
	}

	@Get("/assinantes/{id}/chamados")
	public void lista(long id) {
		result.use(Results.json()).withoutRoot().from(assinanteRepositorio.procuraPorId(id))
				.include("assinante", "listaChamadosDTO", "listaNagiosDTO", "listaIpamDTO", "assinante.endereco",
						"assinante.listaContatoAssinantes", "assinante.listaPlanos",
						"assinante.listaPlanos.statusAssinantePlano", "assinante.listaPlanos.plano",
						"assinante.listaPlanos.plano.servico", "assinante.listaPlanos.plano.categoria")
				.exclude("assinante.listaPlanos.plano.preco", "assinante.listaPlanos.plano.servico.id",
						"assinante.listaPlanos.plano.categoria.id", "listaChamadosDTO.dataAberturaSemFormato")
				.serialize();
	}

	@Put("/assinantes/{id}")
	@Consumes("application/json")
	public void altera(Assinante assinante) {
		assinanteRepositorio.modifica(assinante);
		result.use(Results.json()).withoutRoot().from(assinante)
				.include("endereco", "listaContatoAssinantes", "listaPlanos").serialize();
	}
	
}
