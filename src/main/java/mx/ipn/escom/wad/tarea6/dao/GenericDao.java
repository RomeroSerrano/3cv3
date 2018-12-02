package mx.ipn.escom.wad.tarea6.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.Modelo;

@Service("genericDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericDao {
	@PersistenceContext
	private EntityManager entityManager;

	public <T extends Modelo> T findById(Class<T> clazz, Serializable id) {
		T entidad = entityManager.find(clazz, id);
		return entidad;
	}

	public <T extends Modelo> void update(T entidad) {
		entityManager.merge(entidad);
		entityManager.flush();
	}

	public <T extends Modelo> T save(T entidad) {
		entityManager.persist(entidad);
		return entidad;
	}
}
