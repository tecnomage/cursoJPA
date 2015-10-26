package br.com.populaTabelas;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import br.com.Util.*;
import br.com.conta.*;

public class ContaMain {
	
	public static void main(String[] args) {
		
		
		System.out.println("teste");
		Conta conta = new Conta();
		conta.setBanco("bb tbm");
		conta.setNumero("454545");
		conta.setTitular("vinicius");
		conta.setAgencia("101010101");
		
		
		EntityManager em =new JPAUtil().getEntityManager(); 
		double inicio = System.currentTimeMillis();
		em.getTransaction().begin();
			
		//Conta conta =em.find(Conta.class, 3);
		//System.out.println(conta.getTitular() +" tem conta no banco  " +conta.getBanco());
		
		em.persist(conta);
		em.getTransaction().commit();
		
		//conta.setTitular("francielle");
		
		/**em.getTransaction().begin();
		em.merge(conta);
		em.getTransaction().commit();
		*/
		System.out.println(conta.getTitular());		
		em.close();
		
		
		double fim = System.currentTimeMillis();
		System.out.println(inicio);
		System.out.println(fim);
	}
}
