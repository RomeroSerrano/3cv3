package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;
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
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;

/**
 * Servlet implementation class ContactoCtrl
 */
@WebServlet("/ContactoCtrl")
public class ContactoCtrl extends HttpServlet {
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
    public ContactoCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute(NombreObjetosSession.USER));
		Object username = session.getAttribute(NombreObjetosSession.USER);
		if(username == null)
			response.sendRedirect("LoginCtrl");

		this.usuario = usuarioBs.buscarByUserName(username.toString());
		request.setAttribute("usuario", this.usuario);
		this.persona = usuario.getPersona();

		List<Contacto> contactos = this.persona.getContacto();
		request.setAttribute("contactos", contactos);

		RequestDispatcher rd = request.getRequestDispatcher("contacto/contacto.jsp");
		rd.forward(request, response);
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
		doGet(request, response);
	}
}
