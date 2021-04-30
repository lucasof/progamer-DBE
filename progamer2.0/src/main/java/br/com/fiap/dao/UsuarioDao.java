package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Usuario;
import br.com.fiap.utils.JPAUtil;

public class UsuarioDao {

	public void save(Usuario usuario) {
		EntityManager manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		manager.close();		
	}

	public List<Usuario> getAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> createQuery = manager.createQuery(jpql, Usuario.class);
		// manager.close();
		return createQuery.getResultList();
		
	}

}
