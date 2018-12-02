package mx.ipn.escom.wad.tarea6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.tarea6.bs.LoginBs;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.NombreObjetosSession;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;
import mx.ipn.escom.wad.tarea6.util.FieldErrors;
import mx.ipn.escom.wad.tarea6.util.Message;
import mx.ipn.escom.wad.tarea6.util.Message.MessageType;
import mx.ipn.escom.wad.tarea6.util.PropertyAccess;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginBs loginBs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrl() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login/index.jsp");
		HttpSession session = request.getSession();
		Message mensaje = (Message) session.getAttribute(NombreObjetosSession.GLOBAL_MESSAGE);
		session.removeAttribute(NombreObjetosSession.GLOBAL_MESSAGE);
		request.setAttribute(NombreObjetosSession.GLOBAL_MESSAGE, mensaje);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario;
		HttpSession session = request.getSession();
		FieldErrors fieldErrors;
		try {
			// Logica de negocios para tratar la respuesta de
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			fieldErrors = validarUsuario(username, password);
			if (!fieldErrors.hasErrors()) {
				usuario = loginBs.login(username, password);
				session.setAttribute(NombreObjetosSession.USER, usuario);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				System.out.println("--> " + usuario.getLogin());
				rd.forward(request, response);
			} else {
				System.out.println("--> Falta login");
				Message message = new Message(MessageType.MESSAGE_DANGER, PropertyAccess.getProperty("MSG1"));
				session.setAttribute(NombreObjetosSession.GLOBAL_MESSAGE, message);
				session.setAttribute(NombreObjetosSession.FIELD_ERRORS, fieldErrors);
				response.sendRedirect("LoginCtrl");
			}
		} catch (UserNotFoundException e) {
			Message message = new Message(MessageType.MESSAGE_DANGER, PropertyAccess.getProperty("MSG1"));
			session.setAttribute(NombreObjetosSession.GLOBAL_MESSAGE, message);
			response.sendRedirect("LoginCtrl");
		} catch (UserBlockedException e) {

		}
	}

	private FieldErrors validarUsuario(String username, String password) {
		FieldErrors fieldErrors = new FieldErrors();
		if (username == null || (username != null && username.equals(""))) {
			fieldErrors.add("username", PropertyAccess.getProperty("MSG2"));
		}
		if (password == null || (password != null && password.equals(""))) {
			fieldErrors.add("password", PropertyAccess.getProperty("MSG2"));
		}
		return fieldErrors;
	}

}
