package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Assinante;

public interface AssinanteDao extends InterfaceGenericDao<Assinante>{
	
	public List<Assinante> search(String nome);
	
	public Assinante findById (long id);
	
	public Assinante findByCnpj (String cnpj);
	
}
