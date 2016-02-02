package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.PlanoDao;
import br.com.l0k0s.portal.interfaces.repositorio.PlanoRepositorio;
import br.com.l0k0s.portal.model.Plano;

/*
 * Autor: Alexandre
 * Classe responsável de enviar o repositorio de Plano para a DAO
 * Utiliza a referencia ServocpDao que é uma Interface já que não importa como vai ser
 * feito (JDBC, JPA, Hibernate, etc) e sim o que vai ser implementado.
 * Ao injetar no contrutor o CDI vai buscar à classe que Implementa PlanoDao
 * para ser utilizada.
 * Construtor @Deprecated vazio já que o CDI obriga a implementar.
 * Repositorios baseados no DDD.
 */

public class PlanoRepositorioDao implements PlanoRepositorio {

	private final PlanoDao planoDao;

	@Deprecated
	public PlanoRepositorioDao() {
		this(null);
	}

	@Inject
	public PlanoRepositorioDao(PlanoDao planoDao) {
		this.planoDao = planoDao;
	}

	@Override
	public void guarda(Plano plano) {

		planoDao.save(plano);

	}

	@Override
	public List<Plano> listAll() {

		return planoDao.listAll();

	}

	@Override
	public List<Plano> search(String nome) {

		return planoDao.search(nome);

	}

	@Override
	public void modifica(Plano plano) {
		planoDao.update(plano);
	}

	@Override
	public void retira(long id) {
		planoDao.delete(id);
	}

	@Override
	public Plano verificaSeExiste(Plano plano) {		
		return planoDao.checkIfThere(plano);
	}



}
