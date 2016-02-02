package br.com.l0k0s.portal.interfaces.repositorio;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Plano;

public interface PlanoRepositorio extends InterfaceGenericRepositorio<Plano>{
	
	public List<Plano> search(String nome);

}
