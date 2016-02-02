package br.com.l0k0s.portal.dto;

public class QuantidadeChamadosDTO {
	private final String setor_id;
	private final String status_id;
	private final String qt;
	
	public QuantidadeChamadosDTO(String setor_id, String status_id, String qt){
		this.qt = qt;
		this.status_id = status_id;
		this.setor_id = setor_id;
	}

	public String getSetor_id() {
		return setor_id;
	}

	public String getStatus_id() {
		return status_id;
	}
	
	public String getQt() {
		return qt;
	}
}
