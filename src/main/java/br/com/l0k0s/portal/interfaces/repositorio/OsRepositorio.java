package br.com.l0k0s.portal.interfaces.repositorio;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Os;

public interface OsRepositorio extends InterfaceGenericRepositorio<Os> {
	
	public Os procuraPorId(long id);
	
}
