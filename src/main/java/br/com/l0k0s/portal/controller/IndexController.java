package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
	
	private Result result;
	
	@Deprecated
	protected IndexController(){}
	
	@Inject
	public IndexController(Result result){
		this.result = result;
	}
	
	@Get("/")
	public void index(){
		result.of(this).index();
	}
	
	@Get("/assinante")
	public void indexAssinante(){
		result.of(this).index();
	}
	
	@Get("/assinante/*")
	public void indexAssinanteAll(){
		result.of(this).index();
	}
	
	@Get("/plano")
	public void indexPlano(){
		result.of(this).index();
	}
	
	@Get("/chamado")
	public void indexChamado(){
		result.of(this).index();
	}
	
	@Get("/usuario")
	public void indexUsuario(){
		result.of(this).index();
	}
	
	@Get("/administracao")
	public void indexAdm(){
		result.of(this).index();
	}
	
	@Get("/administracao/*")
	public void indexAdmAll(){
		result.of(this).index();
	}
	
}
