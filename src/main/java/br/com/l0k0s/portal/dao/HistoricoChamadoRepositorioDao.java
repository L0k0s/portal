package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.HistoricoChamadoDao;
import br.com.l0k0s.portal.interfaces.repositorio.HistoricoChamadoRepositorio;
import br.com.l0k0s.portal.model.HistoricoChamado;

public class HistoricoChamadoRepositorioDao implements HistoricoChamadoRepositorio {

	private final HistoricoChamadoDao historicoChamadoDao;
	
	
	@Deprecated
	public HistoricoChamadoRepositorioDao() {
		this(null);
	} 
	
	@Inject
	public HistoricoChamadoRepositorioDao(HistoricoChamadoDao historicoChamadoDao){
		this.historicoChamadoDao = historicoChamadoDao;
	}
	
	@Override
	public void guarda(HistoricoChamado historicoChamado) {
		historicoChamadoDao.save(historicoChamado);
	}

	@Override
	public List<HistoricoChamado> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifica(HistoricoChamado historicoChamado) {
		// TODO Auto-generated method stub

	}

	@Override
	public HistoricoChamado procuraPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistoricoChamado> listaHistoricos(long id) {		
		return historicoChamadoDao.listChamados(id);
	}

	@Override
	public HistoricoChamado verificaSeExiste(HistoricoChamado objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
