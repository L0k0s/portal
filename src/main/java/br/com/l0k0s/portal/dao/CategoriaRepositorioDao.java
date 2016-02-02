package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.CategoriaDao;
import br.com.l0k0s.portal.interfaces.repositorio.CategoriaRepositorio;
import br.com.l0k0s.portal.model.Categoria;

/*
 * Autor: Alexandre
 * Classe responsável de enviar o repositorio de Categoria para a DAO
 * Utiliza a referencia CategoriaDao que é uma Interface já que não importa como vai ser
 * feito (JDBC, JPA, Hibernate, etc) e sim o que vai ser implementado.
 * Ao injetar no contrutor o CDI vai buscar à classe que Implementa CategoriaDao
 * para ser utilizada.
 * Construtor @Deprecated vazio já que o CDI obriga a implementar.
 * Repositorios baseados no DDD.
 */

public class CategoriaRepositorioDao implements CategoriaRepositorio{

	private final CategoriaDao categoriaDao;
		
	@Deprecated
	protected CategoriaRepositorioDao (){
		this(null);
	}

	@Inject
	public CategoriaRepositorioDao(CategoriaDao categoriaDao){
		this.categoriaDao = categoriaDao;
	}
	
	@Override
	public void guarda(Categoria categoria) {
		categoriaDao.save(categoria);
	}

	@Override
	public List<Categoria> listAll() {
		return categoriaDao.listAll();
	}

	@Override	
	public void retira(long id) {
		categoriaDao.delete(id);
	}

	@Override
	@Deprecated
	public void modifica(Categoria objeto) {
	}

	@Override
	public Categoria verificaSeExiste(Categoria categoria) { 
		return categoriaDao.checkIfThere(categoria);
	}

}
