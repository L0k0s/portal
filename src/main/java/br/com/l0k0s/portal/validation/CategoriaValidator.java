package br.com.l0k0s.portal.validation;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.l0k0s.portal.interfaces.repositorio.CategoriaRepositorio;
import br.com.l0k0s.portal.model.Categoria;

public class CategoriaValidator {
	
	private Validator validator;
	private CategoriaRepositorio categoriaRepositorio;
	
	@Deprecated
	protected CategoriaValidator() {
		
	}
	
	@Inject
	public CategoriaValidator(Validator validator, CategoriaRepositorio categoriaRepositorio){
		
		this.validator = validator;
		this.categoriaRepositorio = categoriaRepositorio;
		
	}
		
	public void validate(Categoria categoria){
		
		validator.validate(categoria);
		
		Categoria categoriaV = categoriaRepositorio.verificaSeExiste(categoria); 
		
		if (categoriaV != null){
			validator.add(new SimpleMessage("Categoria", "objeto.existente"));
			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();
		}
		
	}
	
}
