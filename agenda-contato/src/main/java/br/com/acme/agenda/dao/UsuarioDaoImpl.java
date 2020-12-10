package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.utils.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao{
	
	

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Usuario> buscarUsuario() {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Query consulta = em.createQuery("SELECT u FROM Usuario u");
		List<Usuario> listaTodosUsuarios = consulta.getResultList();
		em.close();
		
		return listaTodosUsuarios;
	}
	
	@Override
	public Usuario buscarPorEmail(String email) {
		try {
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			
			return em.createNamedQuery("Usuario.buscarPorEmail", Usuario.class)
					.setParameter("email", email)
					.getSingleResult();
			
		}catch (NoResultException e) {
			return null;
		}
	}


}
