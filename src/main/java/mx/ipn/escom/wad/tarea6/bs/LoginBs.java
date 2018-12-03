package mx.ipn.escom.wad.tarea6.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.dao.LoginDao;
import mx.ipn.escom.wad.tarea6.entidad.Acceso;
import mx.ipn.escom.wad.tarea6.entidad.Persona;
import mx.ipn.escom.wad.tarea6.entidad.Usuario;
import mx.ipn.escom.wad.tarea6.exception.UserBlockedException;
import mx.ipn.escom.wad.tarea6.exception.UserNotFoundException;

@Service("loginBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class LoginBs extends GenericBs {

	@Autowired
	private LoginDao loginDao;

	@Transactional(rollbackOn = Exception.class)
	public Usuario login(String username, String password) throws UserNotFoundException, UserBlockedException {
		Usuario usuario = loginDao.buscarUsuarioByUsername(username);
		if (usuario != null) {
			if (usuario.getPassword().equals(passwordDigest(password))) {
				Acceso acceso = usuario.getAcceso();
				if (verificarBloqueoUsuario(acceso)) {
					throw new UserBlockedException();
				} else {
					Persona p = findById(Persona.class, usuario.getId());
				}
			} else {
				registrarIntentoFallido(usuario);
				throw new UserNotFoundException();
			}
		} else {
			throw new UserNotFoundException();
		}
		return usuario;
	}

	private void registrarIntentoFallido(Usuario usuario) {

	}

	private Boolean verificarBloqueoUsuario(Acceso acceso) {
		return false;
	}

	private String passwordDigest(String password) {
		return password;
	}
}
