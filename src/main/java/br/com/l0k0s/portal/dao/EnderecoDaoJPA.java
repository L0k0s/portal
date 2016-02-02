package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.EnderecoDao;
import br.com.l0k0s.portal.model.Endereco;

@Transactional
public class EnderecoDaoJPA implements EnderecoDao {
	
	private  EntityManager manager;
	
	@Deprecated
	public EnderecoDaoJPA() {}
	
	@Inject
	public EnderecoDaoJPA(EntityManager manager){
		this.manager = manager;
	}
	
	@Override
	public void save(Endereco objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Endereco> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Endereco objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public Endereco findById(long id) {
		
		return manager.find(Endereco.class, id);
	}

	@Override
	public Endereco checkIfThere(Endereco objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
