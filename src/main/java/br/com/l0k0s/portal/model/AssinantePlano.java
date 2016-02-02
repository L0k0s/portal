package br.com.l0k0s.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AssinantePlano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "assinante_id")
	private Assinante assinante;

	@ManyToOne
	@JoinColumn(name = "plano_id")
	private Plano plano;

	@ManyToOne
	@JoinColumn(name= "statusAssinantePlano_id")
	private StatusAssinantePlano statusAssinantePlano;
	
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

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public StatusAssinantePlano getStatusAssinantePlano() {
		return statusAssinantePlano;
	}

	public void setStatusPlanoAssinante(StatusAssinantePlano statusAssinantePlano) {
		this.statusAssinantePlano = statusAssinantePlano;
	}

}
