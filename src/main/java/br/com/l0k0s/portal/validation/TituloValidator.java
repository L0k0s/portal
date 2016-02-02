package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.TituloRepositorio;
import br.com.l0k0s.portal.model.Titulo;


/*
 * Autor: Alexandre
 * Classe utilizada para validar o Serviço seja no banco de dados ou outra
 * validação que não é possivel ser efetuada pelo beans validation
 */

public class TituloValidator  {
	
	private Validator validator;
	private TituloRepositorio tituloRepositorio;
	
	@Deprecated
	public TituloValidator() {}
	
	@Inject
	public TituloValidator(Validator validator, TituloRepositorio tituloRepositorio){
		this.validator = validator;
		this.tituloRepositorio = tituloRepositorio;
	}
	
	public void validate (Titulo titulo){
		
		validator.validate(titulo);
		
		Titulo tituloV = tituloRepositorio.verificaSeExiste(titulo);
		
		if(tituloV != null){
			validator.add(new SimpleMessage("Serviço", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
		
	}

}
