package mx.ipn.escom.wad.tarea6.bs;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.dao.GenericDao;
import mx.ipn.escom.wad.tarea6.entidad.Modelo;

@Service("genericBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericBs{
	@Autowired
	private GenericDao genericDao;
	
	protected <T extends Modelo> T findById(Class<T> clazz, Serializable id) {
		return genericDao.findById(clazz,id);
	}
	
	protected <T extends Modelo> void update(T entidad) {
		genericDao.update(entidad);
	}
	
	protected <T extends Modelo> T save(T entidad) {
		return genericDao.save(entidad);
	}
}
