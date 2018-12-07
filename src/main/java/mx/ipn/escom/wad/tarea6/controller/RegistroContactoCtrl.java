package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.tarea6.bs.ContactoBs;
import mx.ipn.escom.wad.tarea6.bs.PersonaBs;
import mx.ipn.escom.wad.tarea6.bs.PersonaContactoBs;
import mx.ipn.escom.wad.tarea6.bs.UsuarioBs;
import mx.ipn.escom.wad.tarea6.entidad.Contacto;
import mx.ipn.escom.wad.tarea6.entidad.ContactoId;
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.PersonaContacto;
import mx.ipn.escom.wad.tarea6.entidad.PersonaContactoId;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;
import mx.ipn.escom.wad.tarea6.util.FieldErrors;
import mx.ipn.escom.wad.tarea6.util.Message;
import mx.ipn.escom.wad.tarea6.util.PropertyAccess;
import mx.ipn.escom.wad.tarea6.util.Message.MessageType;

/**
 * Servlet implementation class RegistroContactoCtrl
 */
@WebServlet("/RegistroContactoCtrl")
public class RegistroContactoCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Persona persona;

	@Autowired
	private PersonaBs personaBs;
	@Autowired
	private PersonaContactoBs personaContactoBs;
    @Autowired
	private UsuarioBs usuarioBs;
	@Autowired
	private ContactoBs contactoBs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroContactoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object username = session.getAttribute(NombreObjetosSession.USER);
		if(username == null)
			response.sendRedirect("LoginCtrl");

		this.usuario = usuarioBs.buscarByUserName(username.toString());
		this.persona = usuario.getPersona();

		response.sendRedirect("contacto/registro-contacto.jsp");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FieldErrors fieldErrors = new FieldErrors();

		Persona persona  = obtenerPersona(fieldErrors, request);
		System.out.println("CONTACTO CTRL " + persona.getCurp());

		if (!fieldErrors.hasErrors()) {	
			personaBs.guardar(persona);

			List<PersonaContacto> personaContactos = obtenerPersonaContactos(fieldErrors, request, persona);
			persona.setContactos(personaContactos);

			ContactoId contactoId = new ContactoId(this.persona.getId(), persona.getId());
			Contacto contacto = new Contacto();
			contacto.setIdContacto(contactoId);
			contactoBs.guardar(contacto);

			HttpSession session = request.getSession();
			Message message = new Message(MessageType.MESSAGE_SUCCESS, PropertyAccess.getProperty("MSG4"));
			session.setAttribute(NombreObjetosSession.GLOBAL_MESSAGE, message);
			response.sendRedirect(request.getContextPath() + "/ContactoCtrl");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("contacto/registro-contacto.jsp");
			request.setAttribute("fieldErrors", fieldErrors);
			rd.forward(request, response);
		}
	}

	private Persona obtenerPersona(FieldErrors fieldErrors, HttpServletRequest request) {
		Persona persona = new Persona();
		try {
			String nombre = request.getParameter("persona.nombre");
			String primerApellido = request.getParameter("persona.primerApellido");
			String segundoApellido = request.getParameter("persona.segundoApellido");
			String curp = request.getParameter("persona.curp");
			String nacimiento = request.getParameter("persona.nacimiento");
			if (nombre != null && !nombre.equals("")) {
				persona.setNombre(nombre);
			} else {
				fieldErrors.add("persona.nombre", PropertyAccess.getProperty("MSG2"));
			}
			if(primerApellido != null && !primerApellido.equals(""))
			{
				persona.setPrimerApellido(primerApellido);
			} else {
				fieldErrors.add("persona.primerApellido", PropertyAccess.getProperty("MSG2"));
			}
			if(segundoApellido != null && !segundoApellido.equals(""))
			{
				persona.setSegundoApellido(segundoApellido);
			} else {
				fieldErrors.add("persona.segundoApellido", PropertyAccess.getProperty("MSG2"));
			}
			if(curp != null && !curp.equals(""))
			{
				persona.setCurp(curp);
			} else {
				fieldErrors.add("persona.curp", PropertyAccess.getProperty("MSG2"));
			}
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha;
			fecha = format.parse(nacimiento);
			persona.setNacimiento(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persona;
	}

	private List<PersonaContacto> obtenerPersonaContactos(FieldErrors fieldErrors, HttpServletRequest request, Persona persona) {
		List<PersonaContacto> personaContactos = new ArrayList<>();
		try {
			String[] contactoValues = request.getParameterValues("contacto.contacto");
			String[] tipoContactoValues = request.getParameterValues("contacto.tipoContacto");
			
			for (int i = 0; i < contactoValues.length; i++) {
				PersonaContacto personaContacto = new PersonaContacto();
				personaContacto.setContacto(contactoValues[i]);
				personaContacto.setIdTipoContacto(Integer.parseInt(tipoContactoValues[i]));

				personaContacto.setIdPersona(persona.getId());

				PersonaContactoId personaContactoId = new PersonaContactoId(persona.getId(), personaContacto.getIdTipoContacto());
				personaContacto.setPersonaContactoId(personaContactoId);
				personaContactoBs.guardar(personaContacto);
				personaContactos.add(personaContacto);
			}
		}
		catch(Exception e) {
			
		}

		return personaContactos;
	}

}
