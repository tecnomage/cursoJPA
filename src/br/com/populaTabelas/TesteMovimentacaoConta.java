package br.com.populaTabelas;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.lang.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import br.com.Util.JPAUtil;
import br.com.conta.Conta;
import br.com.conta.Movimentacao;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		//Movimentacao movimentacao= em.find(Movimentacao.class,11);
		
		try {
			Conta conta = em.find(Conta.class,3);

			System.out.println(conta.getBanco());
			
			//Query query = em.createQuery("Select c from Conta c join fetch c.movimentacoes");
			
			
			Query query = em.createQuery("select c from Conta  c where c.id= :pContaID");
			
			  query.setParameter("pContaID", conta.getId());
			//query.setParameter("pContaID", conta.getId());
			
			  		  
 
			  List<Conta> contas = query.getResultList();
			
			for (Conta contaResultado : contas) {
				
				System.out.println("\n o titular da conta é  " + contaResultado.getTitular());
				
			}
			
			//mostra o titular da conta de uma determinada movimentaçao
			//System.out.println("titular da conta = " + movimentacao.getConta().getTitular());
			//System.out.println("numero de movimentacoes = " + conta.getMovimentacoes().size());
			
			
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
