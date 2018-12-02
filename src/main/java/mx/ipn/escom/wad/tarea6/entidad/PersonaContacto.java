package mx.ipn.escom.wad.tarea6.entidad;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona_contacto")
public class PersonaContacto {
	@EmbeddedId
	private PersonaContactoId id;
	@Column(name = "id_persona", insertable = false, updatable = false)
	private Integer idPersona;
	@Column(name = "id_tipo", insertable = false, updatable = false)
	private Integer idTipoContacto;
	@Column(name = "tx_contacto")
	private String contacto;
	@ManyToOne
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoContacto tipo;

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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
