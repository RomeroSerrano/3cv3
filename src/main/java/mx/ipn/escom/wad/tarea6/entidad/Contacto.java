package mx.ipn.escom.wad.tarea6.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto implements Modelo {

    @Id
    @Column(name = "id_contacto")
    private Integer id;
    @Column(name = "id_persona")
    private Integer idPersona;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

}