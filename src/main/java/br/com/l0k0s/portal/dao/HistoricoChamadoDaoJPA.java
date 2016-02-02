package br.com.l0k0s.portal.dao;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.interfaces.dao.HistoricoChamadoDao;
import br.com.l0k0s.portal.model.HistoricoChamado;

@Transactional
public class HistoricoChamadoDaoJPA implements HistoricoChamadoDao {
	
	private EntityManager manager;
	
	@Deprecated
	public HistoricoChamadoDaoJPA() {}
	
	@Inject
	public HistoricoChamadoDaoJPA(EntityManager manager){
		this.manager = manager;
	}
	
	public void save(HistoricoChamado historicoChamado) {
		historicoChamado.setDataHora(Calendar.getInstance()); 
		manager.persist(historicoChamado);
	}

	@Override
	public List<HistoricoChamado> listAll() {
	
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(HistoricoChamado objeto) {
		// TODO Auto-generated method stub

	}

	@Override
	public HistoricoChamado findById(long id) {		
		//manager.createQuery(qlString, resultClass);
		return null;
	}

	@Override
	public List<HistoricoChamado> listChamados(long id) {		
		List<HistoricoChamado> historico = manager.createQuery("Select hc from HistoricoChamado hc where hc.chamado.id = :id ORDER BY hc.dataHora DESC", HistoricoChamado.class)
				.setParameter("id", id)
				.getResultList();
	return historico;
	}

	@Override
	public HistoricoChamado checkIfThere(HistoricoChamado objeto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
