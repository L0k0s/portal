package br.com.l0k0s.portal.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class FabricaDaJPA {

	/**
	 * O PersistenceContext é para informar que o servidor de aplicação Wildfly
	 * que vai fazer o gerenciamento do BD.
	 * @default seria o do portal.
	 */

	@PersistenceContext
	private EntityManager manager;

	/**
	 * O Produces é necessário para o CDI poder injetar um EntityManager.
	 */
	@Produces
	public EntityManager getManagerDefault() {
		return manager;
	}

}
