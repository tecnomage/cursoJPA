package br.com.populaTabelas;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

import br.com.DAO.MovimentacaoDAO;
import br.com.Util.JPAUtil;
import br.com.conta.Conta;
import br.com.conta.Movimentacao;
import br.com.conta.TipoMovimentacao;

public class PopulaFuncoesTeste {
	
	public static void main(String[] args) {
		
	

try {
		
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(4);
		

		// Query query = manager
		// 		.createQuery("select m from Movimentacao m where m.conta=?1"
		// 				+ " and m.tipoMovimentacao=?2");

		// query.setParameter(1, conta);
		// query.setParameter(2, TipoMovimentacao.ENTRADA);

		
		//query sem ser TYPEDSAFE
		/**Query query =  em.createQuery("select sum(m.valor) from Movimentacao m where "
									+ "m.conta= :pConta and m.tipoMovimentacao = :pTipo");
		*/
		
					
		//Query TypedSAFE
		TypedQuery<Double> query = em.createNamedQuery("mediaDaContaPeloTipoDeMovimentacao", Double.class);
				
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		
		Double media= query.getSingleResult();
		System.out.println(media);
		
		/** usando a clase MovimentacaoDAO
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		Double media = movimentacaoDao.media(conta, TipoMovimentacao.SAIDA);
		System.out.println(media);
		**/
		
		em.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
							}
	
	}	
	
}
