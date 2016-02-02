package br.com.l0k0s.portal.dto;

import java.util.Calendar;

public class ChamadoEmAndamentoDTO extends ChamadosDTO{

	private final String nome;	
	private final Long idAssinante;		
	
	public ChamadoEmAndamentoDTO(Calendar dataAberturaSemFormato, String statusChamado,
			String tituloChamado, Long idChamado, String nome, Long idAssinante, String setor, String servico) {
		super(dataAberturaSemFormato, statusChamado, tituloChamado, idChamado, setor, servico);
		this.nome = nome;
		this.idAssinante = idAssinante;		
	}

	public String getNome() {
		return nome;
	}

	public Long getIdAssinante() {
		return idAssinante;
	}
}
