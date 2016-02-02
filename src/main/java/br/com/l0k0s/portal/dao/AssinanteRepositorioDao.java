package br.com.l0k0s.portal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.l0k0s.portal.dto.AssinanteDTO;
import br.com.l0k0s.portal.interfaces.dao.AssinanteDao;
import br.com.l0k0s.portal.interfaces.repositorio.AssinanteRepositorio;
import br.com.l0k0s.portal.interfaces.repositorio.ChamadoRepositorio;
import br.com.l0k0s.portal.model.Assinante;

public class AssinanteRepositorioDao implements AssinanteRepositorio {

	private final AssinanteDao assinanteDao;
	private final ChamadoRepositorio chamadoRepositorio;

	@Deprecated
	public AssinanteRepositorioDao() {
		this(null, null);
	}

	@Inject
	public AssinanteRepositorioDao(AssinanteDao assinanteDao, ChamadoRepositorio chamadoRepositorio) {
		this.assinanteDao = assinanteDao;
		this.chamadoRepositorio = chamadoRepositorio;
	}

	@Override
	public void guarda(Assinante assinante) {

		assinanteDao.save(assinante);
	}

	@Override
	public List<Assinante> listAll() {

		return assinanteDao.listAll();
	}

	@Override
	public void retira(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifica(Assinante assinante) {
		assinanteDao.update(assinante);
	}

	@Override
	public List<Assinante> procuraPorNome(String nome) {
		return assinanteDao.search(nome);
	}

	@Override
	public AssinanteDTO procuraPorId(long id) {
		Assinante assinante = assinanteDao.findById(id);
		List<Long> listaIdAssinantePlanos = new ArrayList<>();
		
		for(int x = 0; x < assinante.getListaPlanos().size(); x++){
			listaIdAssinantePlanos.add(assinante.getListaPlanos().get(x).getId());
		}
		
		AssinanteDTO assinanteDTO = new AssinanteDTO(assinante, chamadoRepositorio.searchByIdDTO(id));				
		return assinanteDTO;
	}

	@Override
	public Assinante procuraAssinantePorId(long id) {
		return assinanteDao.findById(id);
	}

	@Override
	public Assinante procuraPorCnpj(String cnpj) {
		return assinanteDao.findByCnpj(cnpj);
	}

	@Override
	public Assinante verificaSeExiste(Assinante assinante) {
		return assinanteDao.checkIfThere(assinante);
	}

}
