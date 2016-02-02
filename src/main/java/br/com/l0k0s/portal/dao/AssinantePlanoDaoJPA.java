package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.AssinantePlanoDao;
import br.com.l0k0s.portal.model.AssinantePlano;

@Transactional
public class AssinantePlanoDaoJPA implements AssinantePlanoDao {

	private EntityManager manager;
	
	@Deprecated
	public AssinantePlanoDaoJPA() {}
	
	@Inject
	public AssinantePlanoDaoJPA(EntityManager manager){
		this.manager = manager;
	}
	
	@Override
	public void save(AssinantePlano objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AssinantePlano> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AssinantePlano assinantePlano) {
		AssinantePlano assinantePlanoAlteraStatus = manager.find(AssinantePlano.class, assinantePlano.getId());
		//assinantePlanoAlteraStatus.getStatusAssinantePlano().setId(assinantePlano.getStatusAssinantePlano().getId());;
		assinantePlanoAlteraStatus.setStatusPlanoAssinante(assinantePlano.getStatusAssinantePlano());
	}

	@Override
	public AssinantePlano checkIfThere(AssinantePlano objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
