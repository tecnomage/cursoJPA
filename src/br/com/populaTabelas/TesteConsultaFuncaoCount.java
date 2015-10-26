package br.com.populaTabelas;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import br.com.Util.JPAUtil;
import br.com.conta.Conta;

public class TesteConsultaFuncaoCount {
	
	public static void main(String[] args) {
		
	
	EntityManager em = new JPAUtil().getEntityManager();
	Conta conta = em.find(Conta.class, 11);
	
	Query query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pconta");
	
	query.setParameter("pconta",conta);
	
	Long quantidade = (Long) query.getSingleResult();	
	
	System.out.println(quantidade);
	
	
	em.close();
	}
}