package mx.ipn.escom.wad.tarea6.bs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.Contacto;

@Service("contactoBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ContactoBs extends GenericBs{

	@Transactional(rollbackOn = Exception.class)
	public Contacto guardar(Contacto contacto) {
		// validaciones
		return save(contacto);
	}
}
