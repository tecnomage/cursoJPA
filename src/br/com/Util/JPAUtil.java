package br.com.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conta2");
	
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager(); 
	}

}
