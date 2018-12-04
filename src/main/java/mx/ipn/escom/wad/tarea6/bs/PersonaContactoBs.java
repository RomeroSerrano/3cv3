package mx.ipn.escom.wad.tarea6.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.PersonaContacto;

@Service("personaContactoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaContactoBs extends GenericBs{
	
	@Transactional(rollbackOn = Exception.class)
	public PersonaContacto guardar(PersonaContacto personaContacto) {
		// validaciones
		return save(personaContacto);
	}
}
