package br.com.l0k0s.portal.interfaces;

import java.util.List;

/*
 * Autor: Thiniel
 */

public interface InterfaceGenericRepositorio<T>{
	public void guarda(T objeto);
	
	public List<T> listAll();

	public void retira(long objeto);
	
	public void modifica(T objeto);
	
	public T verificaSeExiste(T objeto);
}
