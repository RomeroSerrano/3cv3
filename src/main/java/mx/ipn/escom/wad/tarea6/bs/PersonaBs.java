package mx.ipn.escom.wad.tarea6.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.Persona;

@Service("personaBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class PersonaBs extends GenericBs{
	
	@Transactional(rollbackOn = Exception.class)
	public Persona guardar(Persona persona) {
		// validaciones
		return save(persona);
	}
}
