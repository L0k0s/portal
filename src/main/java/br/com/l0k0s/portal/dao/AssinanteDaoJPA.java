package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.AssinanteDao;
import br.com.l0k0s.portal.model.Assinante;

@Transactional
public class AssinanteDaoJPA implements AssinanteDao {

	private EntityManager manager;

	@Deprecated
	public AssinanteDaoJPA() {
	
	}

	@Inject
	public AssinanteDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Assinante assinante) {
				
		for(int i = 0; i < assinante.getListaPlanos().size(); i++){
			assinante.getListaPlanos().get(i).setAssinante(assinante);
		}
		manager.persist(assinante);
	}

	@Override
	public List<Assinante> listAll() {
		
		return manager.createQuery("Select a from Assinante a ", Assinante.class).getResultList();
	}

	@Deprecated
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Assinante assinanteUpdate) {
		for(int i = 0; i < assinanteUpdate.getListaPlanos().size(); i++){
			assinanteUpdate.getListaPlanos().get(i).setAssinante(assinanteUpdate);
		}
		manager.merge(assinanteUpdate);		
	}

	@Override
	public List<Assinante> search(String nome) {
		return manager.createQuery("SELECT a FROM Assinante a WHERE a.nome LIKE :nome OR a.cnpj LIKE :nome OR a.endereco.endereco LIKE :nome", Assinante.class)
									.setParameter("nome", "%" + nome + "%")
									.getResultList();
	}
	
	@Override
	public Assinante findById (long id){
		Assinante assinante = manager.find(Assinante.class, id);
		assinante.getListaContatoAssinantes().size();
		assinante.getListaPlanos().size();
		return assinante;
	}
	
	@Override
	public Assinante findByCnpj(String cnpj) {
		return null;
	}

	@Override
	public Assinante checkIfThere(Assinante objeto) {
		return null;
	}
	
}
