package br.com.l0k0s.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contato")
public class ContatoAssinante {
	
	@Id
	@GeneratedValue
	private long id;		
	
	//private long assinante_id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String telefone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	/**
	 * @return Id do Assinante
	 
	public long getAssinante_id() {
		return assinante_id;
	}

	
	 * @param assinante_id Id do Assinante dono do contato
	
	public void setAssinante_id(long assinante_id) {
		this.assinante_id = assinante_id;
	}
*/
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
