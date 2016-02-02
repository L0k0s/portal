package br.com.l0k0s.portal.interfaces.repositorio;

import java.util.List;

import br.com.l0k0s.portal.dto.ChamadoEmAndamentoDTO;
import br.com.l0k0s.portal.dto.ChamadosDTO;
import br.com.l0k0s.portal.dto.QuantidadeChamadosDTO;
import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Chamado;

public interface ChamadoRepositorio extends InterfaceGenericRepositorio<Chamado> {
	
	public Chamado searchByName(String nome);
	
	public Chamado searchById(long id);
	
	public List<ChamadosDTO> searchByIdDTO(long id);
	
	public List<ChamadoEmAndamentoDTO> searchCalledOpen ();
	
	public List<QuantidadeChamadosDTO> ConutBySetor();
}
