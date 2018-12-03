package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import mx.ipn.escom.wad.tarea6.bs.PersonaBs;
import mx.ipn.escom.wad.tarea6.bs.UsuarioBs;
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;
import mx.ipn.escom.wad.tarea6.util.FieldErrors;
import mx.ipn.escom.wad.tarea6.util.Message;
import mx.ipn.escom.wad.tarea6.util.Message.MessageType;
import mx.ipn.escom.wad.tarea6.util.PropertyAccess;

/**
 * Servlet implementation class RegistroCtrl
 */
@WebServlet("/RegistroCtrl")
public class RegistroCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaBs personaBs;
	@Autowired
	private UsuarioBs usuarioBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("registro/nuevo-registro.jsp");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FieldErrors fieldErrors = new FieldErrors();
		Persona p = obtenerPersona(fieldErrors, request);
		if (!fieldErrors.hasErrors()) {
			personaBs.guardar(p);

			System.out.println("PERSONA ID " + p.getId());

			Usuario u = obtenerUsuario(fieldErrors, request);
			System.out.println("PERSONA ID " + p.getId());
			u.setPersona(p);
			u.setIdPersona(p.getId());

			usuarioBs.guardar(u);

			Message message = new Message(MessageType.MESSAGE_SUCCESS, PropertyAccess.getProperty("MSG4"));
			HttpSession session = request.getSession();
			session.setAttribute(NombreObjetosSession.GLOBAL_MESSAGE, message);
			response.sendRedirect(request.getContextPath() + "/LoginCtrl");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("registro/nuevo-registro.jsp");
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
				fieldErrors.add("persona.nombre", PropertyAccess.getProperty("MSG1"));
				fieldErrors.add("persona.nombre", PropertyAccess.getProperty("MSG2"));
				fieldErrors.add("persona.nombre", PropertyAccess.getProperty("MSG3"));
			}
			persona.setPrimerApellido(primerApellido);
			persona.setSegundoApellido(segundoApellido);
			persona.setCurp(curp);
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

	private Usuario obtenerUsuario(FieldErrors fieldErrors, HttpServletRequest request) {
		Usuario usuario = new Usuario();

		try {
			
			String login = request.getParameter("persona.login");
			String password = request.getParameter("persona.password");
			String passwordConfirm = request.getParameter("persona.passwordConfirm");

			usuario.setLogin(login);
			usuario.setPassword(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

}
