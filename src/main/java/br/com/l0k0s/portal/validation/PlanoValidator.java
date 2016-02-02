package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.PlanoRepositorio;
import br.com.l0k0s.portal.model.Plano;


/*
 * @Autor: Alexandre
 * Classe responsável pela validação do plano
 * A primeira linha do metodo validade faz a validação do bean validation  
 */

public class PlanoValidator {

	private Validator validator;
	private PlanoRepositorio planoRepositorio;
	
	@Deprecated
	public PlanoValidator() {}
	
	@Inject
	public PlanoValidator(Validator valida, PlanoRepositorio planoRepositorio){
		this.validator = valida;
		this.planoRepositorio = planoRepositorio;
	}
	
	public void validate(Plano plano){
		
		validator.validate(plano);	
		
		Plano planoV = planoRepositorio.verificaSeExiste(plano);
		
		if(planoV != null){
			validator.add(new SimpleMessage("Plano", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
		
	}
	
}
