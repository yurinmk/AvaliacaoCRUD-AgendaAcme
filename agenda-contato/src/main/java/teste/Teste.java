package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.acme.agenda.model.Contato;
import br.com.acme.agenda.utils.Constantes;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ACME");
		
		EntityManager em = emf.createEntityManager();
		
		Contato c = em.find(Contato.class,18L);
		
		System.out.println(c);

		em.close();
		emf.close();
		
		
	}

}
