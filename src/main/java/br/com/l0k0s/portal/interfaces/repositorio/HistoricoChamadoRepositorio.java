package br.com.l0k0s.portal.interfaces.repositorio;

import java.util.List;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.HistoricoChamado;

public interface HistoricoChamadoRepositorio extends InterfaceGenericRepositorio<HistoricoChamado> {
	
	public HistoricoChamado procuraPorId(long id);
	
	public List<HistoricoChamado> listaHistoricos(long id);
}
