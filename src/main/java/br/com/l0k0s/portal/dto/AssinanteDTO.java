package br.com.l0k0s.portal.dto;

import java.util.List;

import br.com.l0k0s.portal.model.Assinante;

public class AssinanteDTO {
	
	private final Assinante assinante;
	private final List<ChamadosDTO> listaChamadosDTO;
	
	public AssinanteDTO (Assinante assinante, List<ChamadosDTO> listaChamadosDTO){
		this.assinante = assinante;
		this.listaChamadosDTO = listaChamadosDTO;
	}	

	public Assinante getAssinante() {
		return assinante;
	}

	public List<ChamadosDTO> getChamadosVO() {
		return listaChamadosDTO;
	}

}
