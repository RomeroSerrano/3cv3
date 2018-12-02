package mx.ipn.escom.wad.tarea6.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acceso")
public class Acceso implements Modelo{
	@Id
	@Column(name = "id_acceso")
	private Integer id;
	@Column(name = "nu_intento")
	private Integer intentos;
	@Column(name = "fh_fallido")
	private Date ultimoIntetentoFallido;
	@Column(name = "fh_bloqueo")
	private Date bloqueo;

	public Acceso() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Date getUltimoIntetentoFallido() {
		return ultimoIntetentoFallido;
	}

	public void setUltimoIntetentoFallido(Date ultimoIntetentoFallido) {
		this.ultimoIntetentoFallido = ultimoIntetentoFallido;
	}

	public Date getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Date bloqueo) {
		this.bloqueo = bloqueo;
	}
}
