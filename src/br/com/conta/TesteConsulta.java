package br.com.conta;
 import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.persistence.*;

import br.com.Util.JPAUtil;

public class TesteConsulta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager(); 
		
		Conta conta = new Conta();
		conta.setId(11);
		System.out.println(conta.getId());
		
		//Query query = em.createQuery("select m from movimentacao m where m.conta.id =" + conta.getId()); 
		
		Query query = em
				.createQuery("select m from Movimentacao m where m.conta.id ="
						+ conta.getId());
		//List<Conta> c = query.getResultList();
		
		/*for (Conta conta2 : c) {
			System.out.println(conta2.getTitular());
		}*/
		

		//pega o resultado da query e seta no List 
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			
			System.out.println("\n Descricao é  " + m.getDescricao());
			System.out.println("o velor é " + m.getValor());
			
		}
		em.close();
	}

}
