package br.com.l0k0s.portal.interfaces.dao;

import java.util.List;

import br.com.l0k0s.portal.dto.ChamadoEmAndamentoDTO;
import br.com.l0k0s.portal.dto.ChamadosDTO;
import br.com.l0k0s.portal.dto.QuantidadeChamadosDTO;
import br.com.l0k0s.portal.interfaces.InterfaceGenericDao;
import br.com.l0k0s.portal.model.Chamado;

public interface ChamadoDao extends InterfaceGenericDao<Chamado> {
	
	public Chamado findByName(String nome);
	
	public Chamado findById(long id);
	
	public List<ChamadosDTO> findByIdDTO(long id);
	
	public List<ChamadoEmAndamentoDTO> getCalledOpen();
	
	public List<QuantidadeChamadosDTO> getQtBySetor();
}
