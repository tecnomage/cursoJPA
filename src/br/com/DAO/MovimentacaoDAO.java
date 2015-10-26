package br.com.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.Util.JPAUtil;
import br.com.conta.Conta;
import br.com.conta.TipoMovimentacao;

public class MovimentacaoDAO {
	
	
	
	public MovimentacaoDAO(EntityManager manager) {
		this.em=manager;
	}
		
	private EntityManager em;

			
	public Double media(Conta conta, TipoMovimentacao tipoMov) {
		// TODO Auto-generated method stub
		//Query TypedSAFE
		TypedQuery<Double> query = em.createQuery("select avg(m.valor) from Movimentacao m where "
				+ "m.conta= :pConta and m.tipoMovimentacao = :pTipo", Double.class);
				
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		
		Double media= query.getSingleResult();
				
		return media;
	}
}