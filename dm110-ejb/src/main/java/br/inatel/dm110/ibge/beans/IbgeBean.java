package br.inatel.dm110.ibge.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;

@Stateless	
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal {

	@Inject
	Logger log;
	
	@PersistenceContext(unitName = "ibge_pu")
	private EntityManager em;
	
	@Override
	public void salvarEstado(StateTO state) {
		log.info("Salvando o state: " + state.getNome());
		State entity = new State(state.getIbge(), state.getSigla(), state.getNome(), state.getArea());
		em.persist(entity);
	}
	
	@Override
	public List<StateTO> listarTodosEstados() {
		log.info("Consultando todos os objetos State");
		TypedQuery<State> query = em.createQuery("select s from State s", State.class);
		
		return toCollectionAPIModel(query.getResultList());
	}

	private List<StateTO> toCollectionAPIModel(List<State> stateList) {
		return stateList.stream().map(IbgeBean::toStateTO).collect(Collectors.toList());
	}
	
	public static StateTO toStateTO(State state) {
		StateTO to = new StateTO();
		to.setArea(state.getArea());
		to.setIbge(state.getIbge());
		to.setNome(state.getNome());
		to.setSigla(state.getSigla());
		return to;
	}
}