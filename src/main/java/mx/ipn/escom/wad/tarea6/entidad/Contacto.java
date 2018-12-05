package mx.ipn.escom.wad.tarea6.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto implements Modelo{
    
    @EmbeddedId
    private ContactoId id;
    @Column(name = "id_persona", insertable = false, updatable = false)
	private Integer idPersona;
    @Column(name = "id_contacto", insertable = false, updatable = false)
    private Integer idContacto;
    @OneToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    private Persona persona;
    @OneToOne
	@JoinColumn(name = "id_contacto", referencedColumnName = "id_persona", insertable = false, updatable = false)
	private Persona personaContacto;

    @Override
    public Integer getId() {
        return null;
    }

    public Integer getIdPersona() {
        return this.idPersona;
    }

    public Integer getIdContacto() {
        return this.idContacto;
    }

    public Persona getPersonaContacto() {
        return this.personaContacto;
    }

    public Persona getPersona() {
        return this.persona;
    }

    @Override
    public void setId(Integer id) {

    }

    public void setIdContacto(ContactoId contactoId) {
        this.id = contactoId;
    }
    
}
