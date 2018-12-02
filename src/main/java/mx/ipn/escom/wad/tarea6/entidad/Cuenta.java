package mx.ipn.escom.wad.tarea6.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta implements Modelo{
	@Id
	@SequenceGenerator(name = "cuenta_id_cuenta_seq", sequenceName = "cuenta_id_cuenta_seq", allocationSize = 1)
	@GeneratedValue(generator = "cuenta_id_cuenta_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_cuenta")
	private Integer id;
	@Column(name = "id_rol")
	private Integer idRol;
	@Column(name = "id_usuario")
	private Integer idUsuario;
	@Column(name = "fh_inicio")
	private Date inicio;
	@Column(name = "fh_fin")
	private Date fin;
	@ManyToOne
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
	private Rol rol;
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	public Cuenta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
