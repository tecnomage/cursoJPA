

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import br.com.Util.*;

public class ContaMovimentacao {
	
	public static void main(String[] args) {
		
		
		System.out.println("teste");
		
		Conta conta = new Conta();
		conta.setBanco("bb tbm");
		conta.setNumero("454545");
		conta.setTitular("braga");
		conta.setAgencia("101010101");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("saque");
		movimentacao.setTipoMovimentacao(tipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("120"));
		movimentacao.setConta(conta);
		
		
				
		EntityManager em =new JpaUtil().getEntityManager(); 
		double inicio = System.currentTimeMillis();
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		conta.setTitular("francielle");
		
				
		em.close();
		
		
		double fim = System.currentTimeMillis();
		System.out.println(inicio);
		System.out.println(fim);
	}
}
