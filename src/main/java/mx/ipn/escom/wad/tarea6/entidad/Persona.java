package mx.ipn.escom.wad.tarea6.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id_persona", referencedColumnName = "id_usuario")
public class Persona implements Modelo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "persona_id_persona_seq", sequenceName = "persona_id_persona_seq", allocationSize = 1)
	@GeneratedValue(generator = "persona_id_persona_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_persona")
	private Integer id;
	@Column(name = "nb_usuario")
	private String nombre;
	@Column(name = "tx_primer_ap")
	private String primerApellido;
	@Column(name = "tx_segundo_ap")
	private String segundoApellido;
	@Column(name = "tx_curp")
	private String curp;
	@Column(name = "fh_nacimiento")
	private Date nacimiento;
	@OneToMany
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
	private List<PersonaContacto> contactos;
	@ManyToMany
	@JoinTable(name = "persona_contacto", joinColumns = {
			@JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false) })
	private List<TipoContacto> tiposContacto;

	public Persona() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<PersonaContacto> getContactos() {
		return contactos;
	}

	public void setContactos(List<PersonaContacto> contactos) {
		this.contactos = contactos;
	}

	public List<TipoContacto> getTiposContacto() {
		return tiposContacto;
	}

	public void setTiposContacto(List<TipoContacto> tiposContacto) {
		this.tiposContacto = tiposContacto;
	}
	
	public String toString() {
		return nombre+" "+primerApellido+" "+segundoApellido;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {

	}
}
