package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Plano;

public interface PlanoDao extends InterfaceGenericDao<Plano> {

	public List<Plano> search(String nome);

	public Plano findById(long id);

}
