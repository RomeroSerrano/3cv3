package mx.ipn.escom.wad.tarea6.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Modelo, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
	@GeneratedValue(generator = "usuario_id_usuario_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Integer id;
	@Column(name = "id_persona")
	private Integer idPersona;
	@Column(name = "tx_login")
	private String login;
	@Column(name = "tx_password")
	private String password;
	@OneToMany(mappedBy = "usuario")
	private List<Cuenta> cuentas;
	@OneToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_acceso", insertable = false, updatable = false)
	private Acceso acceso;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
	private Persona persona;

	public Usuario() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Acceso getAcceso() {
		return acceso;
	}

	public void setAcceso(Acceso acceso) {
		this.acceso = acceso;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return login;
	}
	
	
}
