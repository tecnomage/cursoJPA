package br.com.populaTabelas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.Util.JPAUtil;
import br.com.conta.Conta;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
				
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 11);
		
		TypedQuery<BigDecimal> query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pconta" ,
											BigDecimal.class);
		
		query.setParameter("pconta", conta);
		
		BigDecimal quantidade =  query.getSingleResult();	
		
		System.out.println(quantidade);
		
		em.close();
	 

	}

}
