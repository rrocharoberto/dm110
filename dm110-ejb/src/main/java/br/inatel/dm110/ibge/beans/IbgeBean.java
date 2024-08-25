package br.inatel.dm110.ibge.beans;

import java.util.List;
import java.util.logging.Logger;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.ibge.support.IbgeConverter;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless	
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal {

	@Inject
	Logger log;
	
	// @PersistenceContext(unitName = "ibge_pu")
	// private EntityManager em;
	
	// @Override
	// public void salvarEstado(StateTO to) {
	// 	log.info("Salvando o state: " + to.getNome());
	// 	State entity = IbgeConverter.toEntity(to);
	// 	em.persist(entity);
	// }
	
	// @Override
	// public List<StateTO> listarTodosEstados() {
	// 	log.info("Consultando todos os objetos State");
		
	// 	String hql = "select s from State s";
	// 	TypedQuery<State> query = em.createQuery(hql, State.class);
		
	// 	return IbgeConverter.toTOList(query.getResultList());
	// }
}
