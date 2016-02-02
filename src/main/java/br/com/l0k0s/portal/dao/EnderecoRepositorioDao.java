package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.EnderecoDao;
import br.com.l0k0s.portal.interfaces.repositorio.EnderecoRepositorio;
import br.com.l0k0s.portal.model.Endereco;

public class EnderecoRepositorioDao implements EnderecoRepositorio{
	
	private EnderecoDao enderecoDao;
	
	@Deprecated
	public EnderecoRepositorioDao() {
		this (null);
	}
	
	@Inject
	public EnderecoRepositorioDao(EnderecoDao enderecoDao){
		this.enderecoDao = enderecoDao;
	}
	
	@Override
	public void guarda(Endereco objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifica(Endereco objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco procuraPorId(long id) {
		return enderecoDao.findById(id);
	}

	@Override
	public Endereco verificaSeExiste(Endereco objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
