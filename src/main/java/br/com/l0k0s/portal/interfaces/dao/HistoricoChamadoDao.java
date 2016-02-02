package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.HistoricoChamado;

public interface HistoricoChamadoDao extends InterfaceGenericDao<HistoricoChamado> {
	
	public HistoricoChamado findById (long id);
	public List<HistoricoChamado> listChamados(long id);
	
}
