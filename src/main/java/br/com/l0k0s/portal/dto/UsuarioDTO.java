package br.com.l0k0s.portal.dto;

public class UsuarioDTO {
	
	final private long usuarioId;
	final private String usuarioNome;
	final private String setorNome;
	
	public UsuarioDTO(long usuarioId, String usuarioNome,String setorId) {
		this.usuarioId = usuarioId;
		this.usuarioNome = usuarioNome;
		this.setorNome = setorId;
	}
	
	public long getUsuarioId() {
		return usuarioId;
	}
	
	public String getUsuarioNome() {
		return usuarioNome;
	}
	
	public String getSetorId() {
		return setorNome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((setorNome == null) ? 0 : setorNome.hashCode());
		result = prime * result + (int) (usuarioId ^ (usuarioId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		if (setorNome == null) {
			if (other.setorNome != null)
				return false;
		} else if (!setorNome.equals(other.setorNome))
			return false;
		if (usuarioId != other.usuarioId)
			return false;
		return true;
	}

}
