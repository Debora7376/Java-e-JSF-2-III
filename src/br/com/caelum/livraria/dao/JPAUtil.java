package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");

	@Produces // como produzir
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	// @Disposes como fechar
	public void close(@Disposes EntityManager em) {
		em.close();
	}
}
