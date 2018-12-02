package mx.ipn.escom.wad.tarea6.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_contacto")
public class TipoContacto implements Modelo{
	@Id
	@Column(name = "id_tipo")
	private Integer id;
	@Column(name = "nb_tipo")
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
