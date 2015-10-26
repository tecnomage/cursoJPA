 import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import br.com.Util.JpaUtil;

public class TesteConsulta {
	
	public static void main(String[] args) {
		
		EntityManager em =new JpaUtil().getEntityManager(); 
		Conta conta= new Conta();
		conta.setId(12);
		
		Query query = em.createQuery("select m from movimentacao where m.conta_id=" + conta.getId()); 
		
		System.out.println();
		List<Movimentacao> movimentacoes = query.getResultList();
		
		
		for (Movimentacao m : movimentacoes) {
			
			System.out.println("Descricao é  " + m.getDescricao());
			System.out.println("o velor é " + m.getValor());
			
		}
		
	}

}
