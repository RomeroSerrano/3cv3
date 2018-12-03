package mx.ipn.escom.wad.tarea6.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.Usuario;

@Service("usuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs extends GenericBs{
	
	@Transactional(rollbackOn = Exception.class)
	public Usuario guardar(Usuario usuario) {
		// validaciones
		return save(usuario);
	}
}
