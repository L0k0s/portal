package br.com.l0k0s.portal.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Put;
import br.com.l0k0s.portal.interfaces.repositorio.AssinantePlanoRepositorio;
import br.com.l0k0s.portal.model.AssinantePlano;

@Controller
public class AssinantePlanoController {
	
	private AssinantePlanoRepositorio assinantePlanoRepositorio;
	
	@Deprecated
	public AssinantePlanoController(){}
	
	@Inject
	public AssinantePlanoController(AssinantePlanoRepositorio assinantePlanoRepositorio){
		this.assinantePlanoRepositorio = assinantePlanoRepositorio;
	}
	
	@Put("/assinantePlanos")
	@Consumes("application/json")	
	public void altera(AssinantePlano assinantePlano){
		assinantePlanoRepositorio.modifica(assinantePlano);
	}
}
