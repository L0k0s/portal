package br.com.l0k0s.portal.interfaces.dao;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Endereco;

public interface EnderecoDao extends InterfaceGenericDao<Endereco> {
	
	public Endereco findById(long id);
	
}
