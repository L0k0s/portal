package br.com.l0k0s.portal.interfaces.repositorio;

import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Categoria;


/*
 * Autor: Alexandre
 * Essa interface vai conter os metodos utilizados no repositorio da categoria não importando sua implementação
 * Edit: Thiniel Penna Foti
 * O uso do repositoryo pode ser importante caso haja a necessidade de se consultar mais de uma base visto que
 * o repositorio irá decidir qual DAO será consultada e retornara o resultado, tornando o controller desacoplado
 * da DAO
 */


public interface CategoriaRepositorio extends InterfaceGenericRepositorio<Categoria> {	
	
}
