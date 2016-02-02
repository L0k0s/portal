package br.com.l0k0s.portal.dao;

import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.dto.ChamadoEmAndamentoDTO;
import br.com.l0k0s.portal.dto.ChamadosDTO;
import br.com.l0k0s.portal.dto.QuantidadeChamadosDTO;
import br.com.l0k0s.portal.interfaces.dao.ChamadoDao;
import br.com.l0k0s.portal.interfaces.repositorio.ChamadoRepositorio;
import br.com.l0k0s.portal.model.Chamado;

public class ChamadoRepositorioDao implements ChamadoRepositorio{
	
	private final ChamadoDao chamadoDao;
	
	@Deprecated
	public ChamadoRepositorioDao() {
		this(null);
	}
	
	@Inject
	public ChamadoRepositorioDao(ChamadoDao chamadoDao){
		this.chamadoDao = chamadoDao;
	}

	@Override
	public void guarda(Chamado chamado) {
		chamadoDao.save(chamado);
		
	}

	@Deprecated
	@Override
	public List<Chamado> listAll() {
		return chamadoDao.listAll();
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifica(Chamado chamado) {
		chamadoDao.update(chamado);
		
	}

	@Override
	public Chamado searchByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chamado searchById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChamadosDTO> searchByIdDTO(long id) {		
		return chamadoDao.findByIdDTO(id);
	}

	@Override
	public List<ChamadoEmAndamentoDTO> searchCalledOpen() {		
		return chamadoDao.getCalledOpen();
	}

	@Override
	public List<QuantidadeChamadosDTO> ConutBySetor() {
		return chamadoDao.getQtBySetor();
	}

	@Override
	public Chamado verificaSeExiste(Chamado objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
