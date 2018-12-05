package mx.ipn.escom.wad.tarea6.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Integer id) {

    }

    public void setIdContacto(ContactoId contactoID) {
        this.id = contactoID;
    }
    
}
