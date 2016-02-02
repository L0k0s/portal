package br.com.l0k0s.portal.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.validation.constraints.NotNull;

import br.com.l0k0s.portal.dto.ChamadoEmAndamentoDTO;

@SqlResultSetMapping(
		name = "ChamadoOpenDTOMapping", 
		classes = @ConstructorResult(
				targetClass = ChamadoEmAndamentoDTO.class,
				columns = {
					@ColumnResult(name = "dataAberturaSemFormato", type = Calendar.class),						
					@ColumnResult(name = "statusChamado"),
					@ColumnResult(name = "tituloChamado"),					
					@ColumnResult(name = "idChamado", type = Long.class),					
					@ColumnResult(name = "nomeAssinante"),
					@ColumnResult(name = "idAssinante", type = Long.class),
					@ColumnResult(name = "setor"),
					@ColumnResult(name = "servico"),
				}))		

@Entity
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "assinante_id")
	private Assinante assinante;

	@OneToOne
	@JoinColumn(name = "titulo_id")
	private Titulo titulo;

	@NotNull
	@OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL)
	private List<HistoricoChamado> listaHistoricoChamado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<HistoricoChamado> getListaHistoricoChamados() {
		return listaHistoricoChamado;
	}

	public void setListaHistoricoChamados(List<HistoricoChamado> listaHistoricoChamados) {
		this.listaHistoricoChamado = listaHistoricoChamados;
	}

}
