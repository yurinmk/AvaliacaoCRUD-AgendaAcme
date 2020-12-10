/**
 * 
 */
package br.com.acme.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.utils.JPAUtil;

/**
 * @author TERCEIRA CAMADA
 *
 */
public class ContatoDaoImpl implements ContatoDao {

	@Override
	public void salvar(Contato contato) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(contato);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Contato> listarContatos(Long idUsuario) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		Query consulta = em.createQuery("SELECT c FROM Contato c WHERE id_usuario = " + idUsuario);
		List<Contato> listaDeContatosDoBancoDeDados = consulta.getResultList();
		
		em.close();
		return listaDeContatosDoBancoDeDados;
	}

	@Override
	public void remover(Long idContato) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Contato contato = em.find(Contato.class, idContato);
		em.remove(contato);
		
		em.getTransaction().commit();
		
		em.close();
	}

	@Override
	public Contato buscarPorIdContato(Long idContato) {
		
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		
		Contato contato = em.find(Contato.class, idContato);
		
		
		em.close();
		return contato;

	}

	@Override
	public void editarContato(Long idContato, Contato contato) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Contato contatoQueTavaNoBanco = em.find(Contato.class, idContato);
		contatoQueTavaNoBanco.setAtivo(contato.isAtivo());
		contatoQueTavaNoBanco.setEmail(contato.getEmail());
		contatoQueTavaNoBanco.setTelefone(contato.getTelefone());
		contatoQueTavaNoBanco.setNome(contato.getNome());
		
		em.merge(contatoQueTavaNoBanco);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Contato buscarPorEmail(String email) {
		try {
			
			EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
			
			em.getTransaction().begin();
			
			Contato contato = em.createNamedQuery("Contato.buscarPorEmail", Contato.class)
					.setParameter("email", email)
					.setParameter("idUsuario", JPAUtil.usuario.getId())
					.getSingleResult();
			
			em.getTransaction().commit();
			em.close();
			
			return contato;
			
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public void ativarDesativarContato(Long idContato, boolean valor) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Contato contato = em.find(Contato.class, idContato);
		
		contato.setAtivo(valor);
		em.merge(contato);
		em.getTransaction().commit();
		em.close();
		
	}

}










