package mx.ipn.escom.wad.tarea6.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Modelo{
	@Id
	@Column(name = "id_rol")
	private Integer id;
	@Column(name = "nb_rol")
	private String nombre;
	@Column(name = "ds_rol")
	private String descripcion;
	@OneToMany(mappedBy = "rol")
	private List<Cuenta> cuentas;
	public Rol() {
		
	}
	
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
