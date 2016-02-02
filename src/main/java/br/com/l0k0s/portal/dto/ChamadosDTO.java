package br.com.l0k0s.portal.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChamadosDTO {

	private final Calendar dataAberturaSemFormato;
	private final String statusChamado;
	private final String tituloChamado;
	private final Long idChamado;
	private final String setor;
	private final String servico;
	private String dataAbertura;

	public ChamadosDTO(Calendar dataAberturaSemFormato, String statusChamado, String tituloChamado, Long idChamado,
			String setor, String servico) {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		this.dataAberturaSemFormato = dataAberturaSemFormato;
		dataAbertura = sdf.format(this.dataAberturaSemFormato.getTime());
		this.statusChamado = statusChamado;
		this.tituloChamado = tituloChamado;
		this.idChamado = idChamado;
		this.setor = setor;
		this.servico = servico;
	}

	public Calendar getdataAberturaSemFormato() {
		return dataAberturaSemFormato;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public String getStatusChamado() {
		return statusChamado;
	}

	public String getTituloChamado() {
		return tituloChamado;
	}

	public Long getIdChamado() {
		return idChamado;
	}

	public String getSetor() {
		return setor;
	}
	
	public String getServico(){
		return servico;
	}

}
