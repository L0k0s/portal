package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.ServicoDao;
import br.com.l0k0s.portal.interfaces.repositorio.ServicoRepositorio;
import br.com.l0k0s.portal.model.Servico;

/*
 * Autor: Alexandre
 * Classe responsável de enviar o repositorio de Serviço para a DAO
 * Utiliza a referencia ServocpDao que é uma Interface já que não importa como vai ser
 * feito (JDBC, JPA, Hibernate, etc) e sim o que vai ser implementado.
 * Ao injetar no contrutor o CDI vai buscar à classe que Implementa CategoriaDao
 * para ser utilizada.
 * Construtor @Deprecated vazio já que o CDI obriga a implementar.
 * Repositorios baseados no DDD.
 */

public class ServicoRepositorioDao implements ServicoRepositorio {

	private final ServicoDao servicoDao;

	@Deprecated
	protected ServicoRepositorioDao() {
		this(null);
	}

	@Inject
	public ServicoRepositorioDao(ServicoDao servicoDao) {

		this.servicoDao = servicoDao;

	}

	@Override
	public void guarda(Servico servico) {

		servicoDao.save(servico);

	}

	@Override
	public List<Servico> listAll() {

		return servicoDao.listAll();

	}

	@Override
	public Servico verificaSeExiste(Servico servico) {

		return servicoDao.checkIfThere(servico);
	}

	@Override
	public void retira(long id) {
		servicoDao.delete(id);
	}

	@Override
	@Deprecated
	public void modifica(Servico objeto) {
		// TODO Auto-generated method stub

	}

}
