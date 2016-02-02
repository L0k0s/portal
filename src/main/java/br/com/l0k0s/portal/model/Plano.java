package br.com.l0k0s.portal.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;	
	
	@NotEmpty
	private String nome;
	
	@NotNull
	private BigDecimal preco;
	
	@ManyToOne
	@NotNull
	private Servico servico;
	
	@ManyToOne
	@NotNull
	private Categoria categoria;

	@OneToMany(mappedBy = "plano", cascade = CascadeType.ALL)
	private List<AssinantePlano> listaPlano;
	
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
