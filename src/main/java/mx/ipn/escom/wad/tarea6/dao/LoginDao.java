package mx.ipn.escom.wad.tarea6.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.tarea6.entidad.Usuario;

@Service("loginDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class LoginDao {
	private static final String QUERY_1 = "select this_.id_usuario as id_usuario, this_.tx_login as tx_login,\n"
			+ "this_.tx_password as tx_password, this_1_.id_persona as id_persona, this_1_.tx_curp as tx_curp,\n"
			+ "this_1_.fh_nacimiento as fh_nacimiento, this_1_.nb_usuario as nb_usuario, \n"
			+ "this_1_.tx_primer_ap as tx_primer_ap, this_1_.tx_segundo_ap as tx_segundo_ap, \n"
			+ "case when this_1_.id_persona is not null then 	1 \n"
			+ "when this_.id_usuario is not null then 	0 end as clazz_ \n" + "from usuario this_ \n"
			+ "left outer join persona this_1_ on this_.id_persona=this_1_.id_persona \n"
			+ "where (this_.tx_login=:username)";
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings({ "unchecked"})
	public Usuario buscarUsuarioByUsername(String username) {
		Usuario usuario = null;
		Query q = entityManager.createNativeQuery(QUERY_1, Usuario.class);
		q.setParameter("username", username);
		List<Usuario> usuarios = q.getResultList();
		System.out.println("-->" + usuarios);
		if (!usuarios.isEmpty()) {
			usuario = usuarios.get(0);
		}
		return usuario;
	}
}
