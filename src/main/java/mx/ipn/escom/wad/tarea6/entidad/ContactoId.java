package mx.ipn.escom.wad.tarea6.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContactoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id_persona", nullable = false)
	private Integer idPersona;
	@Column(name = "id_contacto", nullable = false)
	private Integer idContacto;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdTipoContacto() {
		return idContacto;
	}

	public void setIdTipoContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

}
