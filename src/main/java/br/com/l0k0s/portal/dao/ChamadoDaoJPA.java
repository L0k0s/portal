package br.com.l0k0s.portal.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.l0k0s.portal.dto.ChamadoEmAndamentoDTO;
import br.com.l0k0s.portal.dto.ChamadosDTO;
import br.com.l0k0s.portal.dto.QuantidadeChamadosDTO;
import br.com.l0k0s.portal.interfaces.dao.ChamadoDao;
import br.com.l0k0s.portal.model.Chamado;

@Transactional
public class ChamadoDaoJPA implements ChamadoDao {

	private EntityManager manager;

	@Deprecated
	protected ChamadoDaoJPA() {
	}

	@Inject
	public ChamadoDaoJPA(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void save(Chamado chamado) {		
		chamado.getListaHistoricoChamados().get(0).setChamado(chamado);
		manager.persist(chamado);
	}

	@Deprecated
	@Override
	public List<Chamado> listAll() {
		return null;
	}

	@Deprecated
	@Override
	public void delete(long id) {
	}

	@Override
	public void update(Chamado chamadoUpdate) {
		Chamado chamado = this.findById(chamadoUpdate.getId());
		chamado.setListaHistoricoChamados(chamadoUpdate
				.getListaHistoricoChamados());
		manager.merge(chamado);
	}

	@Override
	public Chamado findByName(String nome) {
		return null;
	}

	@Override
	public Chamado findById(long id) {
		Chamado chamado = manager.find(Chamado.class, id);
		chamado.getListaHistoricoChamados().size();
		return chamado;
	}

	@Override
	public List<ChamadosDTO> findByIdDTO(long idCliente) {

		String sql = "select (select min(datahora) from historicochamado where chamado_id = c.id) as dataAberturaSemFormato, s.nome as statusChamado, t.nome as tituloChamado, c.id as idChamado, st.nome as setor, sv.nome as servico from Chamado c"
				+ " join historicochamado hc on c.id = hc.chamado_id"
				+ " join status s on s.id = hc.status_id"
				+ " join setor st on st.id = hc.setor_id"
				+ " join titulo t on t.id = c.titulo_id"
				+ " join servico sv on sv.id = t.servico_id"
				+ " where c.assinante_id = :idCliente"
				+ " and hc.dataHora = (select max(datahora) from historicochamado where chamado_id = c.id)"
				+ " order by dataAberturaSemFormato desc;";

		Query query = manager.createNativeQuery(sql, "ChamadoDTOMapping");
		query.setParameter("idCliente", idCliente);
		
		List<ChamadosDTO> listaChamadosDTO = query.getResultList();
			
		return listaChamadosDTO;
	}

	@Override
	public List<ChamadoEmAndamentoDTO> getCalledOpen() {
			
		String sql = "select (select min(datahora) from historicochamado where chamado_id = c.id) as dataAberturaSemFormato, s.nome as statusChamado, t.nome as tituloChamado, c.id as idChamado, a.nome as nomeAssinante, a.assinante_id as idAssinante, st.nome as setor, sv.nome as servico"
				+ " from Chamado c"
				+ " join historicochamado hc on c.id = hc.chamado_id"
				+ " join status s on s.id = hc.status_id"
				+ " join setor st on st.id = hc.setor_id"
				+ " join titulo t on t.id = c.titulo_id"				
				+ " join assinante a on a.assinante_id = c.assinante_id"
				+ " join servico sv on sv.id = t.servico_id"
				+ " where s.nome <> 'Resolvido'"
				+ " and hc.dataHora = (select max(datahora) from historicochamado where chamado_id = c.id)"
				+ " order by dataAberturaSemFormato desc";

		Query query = manager.createNativeQuery(sql, "ChamadoOpenDTOMapping");
		
		List<ChamadoEmAndamentoDTO> listaChamadoEmAndamentoDTOs = query.getResultList();
		
		return listaChamadoEmAndamentoDTOs;
	}

	@Override
	public List<QuantidadeChamadosDTO> getQtBySetor() {
		
		/*
		 * Como o result vai retornar um array de objects é necessário fazer uma
		 * iteração sobre esse array para depois passar para um ChamadoDTO já
		 * que o Json só aceita um retorno, então foi criada a Classe
		 * ChamadosDTO encapsulando todos os objetos necessários a serem
		 * enviados para view
		 */
		
		String sql = "SELECT str.id setor_id, sts.id status_id, COUNT(c.id) qt "
				+ "FROM Chamado c "
				+ "INNER JOIN historicochamado hc on c.id = hc.chamado_id "
				+ "INNER JOIN setor str ON str.id = hc.setor_id "
				+ "INNER JOIN status sts ON sts.id = hc.status_id "
				+ "WHERE hc.dataHora = (SELECT MAX(datahora) FROM historicochamado WHERE chamado_id = c.id) "
				+ "GROUP BY str.id, sts.id";

		Query query = manager.createNativeQuery(sql);

		List<Object> listaObjs = query.getResultList();
		// List<QuantidadeChamadosDTO> listaQuantidadeChamadosDTOs =
		// query.getResultList();
		List<QuantidadeChamadosDTO> listaQuantidadeChamadosDTOs = new ArrayList<QuantidadeChamadosDTO>();

		for (Iterator<Object> iter = listaObjs.iterator(); iter.hasNext();) {

			Object[] obj = (Object[]) iter.next();

			QuantidadeChamadosDTO quantidadeChamadosDTO = new QuantidadeChamadosDTO(
					obj[0].toString(), obj[1].toString(), obj[2].toString());

			listaQuantidadeChamadosDTOs.add(quantidadeChamadosDTO);
		}

		return listaQuantidadeChamadosDTOs;
	}

	@Override
	@Deprecated
	public Chamado checkIfThere(Chamado objeto) {return null;}
}
