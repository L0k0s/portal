package br.com.l0k0s.portal.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.l0k0s.portal.dto.ChamadosDTO;

@SqlResultSetMapping(
		name = "ChamadoDTOMapping", 
		classes = @ConstructorResult(
				targetClass = ChamadosDTO.class,
				columns = {
					@ColumnResult(name = "dataAberturaSemFormato", type = Calendar.class),						
					@ColumnResult(name = "statusChamado"),
					@ColumnResult(name = "tituloChamado"),					
					@ColumnResult(name = "idChamado", type = Long.class),
					@ColumnResult(name = "setor"),
					@ColumnResult(name = "servico"),
				}))

@Entity
public class Assinante {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "assinante_id")
	private long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String cnpj;
	
	@OneToOne (cascade = CascadeType.ALL)	
	private Endereco endereco;
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn (name = "assinante_id")
	private List<ContatoAssinante> listaContatoAssinantes;
	
	@OneToMany(mappedBy = "assinante", cascade = CascadeType.ALL)	
	private List<AssinantePlano> listaPlanos;
	
	@OneToMany (mappedBy = "assinante")
	private List<Chamado>  listaChamados;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ContatoAssinante> getListaContatoAssinantes() {
		return listaContatoAssinantes;
	}

	public void setListaContatoAssinantes(
			List<ContatoAssinante> listaContatoAssinantes) {
		this.listaContatoAssinantes = listaContatoAssinantes;
	}

	public List<AssinantePlano> getListaPlanos() {
		return listaPlanos;
	}

	public void setListaPlanos(List<AssinantePlano> listaPlanos) {
		this.listaPlanos = listaPlanos;
	}
	
	public List<Chamado> getListaChamados() {
		return listaChamados;
	}

	public void setListaChamados(List<Chamado> listaChamados) {
		this.listaChamados = listaChamados;
	}	
	
}
