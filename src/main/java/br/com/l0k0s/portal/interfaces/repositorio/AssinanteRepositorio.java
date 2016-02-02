package br.com.l0k0s.portal.interfaces.repositorio;

import java.util.List;

import br.com.l0k0s.portal.dto.AssinanteDTO;
import br.com.l0k0s.portal.interfaces.InterfaceGenericRepositorio;
import br.com.l0k0s.portal.model.Assinante;

public interface AssinanteRepositorio extends InterfaceGenericRepositorio<Assinante> {
	
	public List<Assinante> procuraPorNome (String nome);
	
	public AssinanteDTO procuraPorId (long id);
	
	public Assinante procuraAssinantePorId(long id);
		
	public Assinante procuraPorCnpj(String cnpj);
}
