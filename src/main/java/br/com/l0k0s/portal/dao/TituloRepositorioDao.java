package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.interfaces.dao.TituloDao;
import br.com.l0k0s.portal.interfaces.repositorio.TituloRepositorio;
import br.com.l0k0s.portal.model.Titulo;

public class TituloRepositorioDao implements TituloRepositorio {
	
	private TituloDao tituloDao;
	
	@Deprecated
	public TituloRepositorioDao() {
		this(null);
	}
	
	@Inject
	public TituloRepositorioDao(TituloDao tituloDao){
		this.tituloDao = tituloDao;
	}
	
	@Override
	public void guarda(Titulo titulo) {
		tituloDao.save(titulo);

	}

	@Override
	public List<Titulo> listAll() {
		
		return tituloDao.listAll();
	}

	@Override
	public void retira(long id) {		
		tituloDao.delete(id);
	}

	@Override
	public void modifica(Titulo titulo) {
		// TODO Auto-generated method stub

	}

	@Override
	public Titulo verificaSeExiste(Titulo titulo) {
		return tituloDao.checkIfThere(titulo);
	}

}
