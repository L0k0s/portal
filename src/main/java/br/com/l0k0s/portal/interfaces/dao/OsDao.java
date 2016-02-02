package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Os;

public interface OsDao extends InterfaceGenericDao<Os> {
	
	public Os findById (long id);
	
	public List<Os> listAll(long id);
	
}
