package br.com.l0k0s.portal.interfaces;

import java.util.List;

public interface InterfaceGenericDao<T> {
	
	public void save(T objeto);
	
	public List<T> listAll();

	public void delete(long id);
	
	public void update(T objeto);
	
	public T checkIfThere(T objeto);
}
