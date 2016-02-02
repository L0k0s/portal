package br.com.l0k0s.portal.interfaces.repositorio;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Endereco;

public interface EnderecoRepositorio extends InterfaceGenericRepositorio<Endereco> {
	
	public Endereco procuraPorId(long id);
	
}
