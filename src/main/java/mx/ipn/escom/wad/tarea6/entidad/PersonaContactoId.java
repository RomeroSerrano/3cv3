package mx.ipn.escom.wad.tarea6.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaContactoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_persona", nullable = false)
	private Integer idPersona;
	@Column(name = "id_tipo", nullable = false)
	private Integer idTipoContacto;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdTipoContacto() {
		return idTipoContacto;
	}

	public void setIdTipoContacto(Integer idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

}
