package br.inatel.dm110.ibge.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;

@Stateless
//@Remote(IbgeRemote.class)
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal {// , IbgeRemote {

	private static Logger log = Logger.getLogger(IbgeBean.class.getName());

	@PersistenceContext(unitName = "ibge_pu")
	private EntityManager em;

	@Override
	public void salvarEstado(StateTO state) {
		log.info("Saving state: " + state);

		State st = new State(state.getIbge(), state.getSigla(), state.getNome(), state.getArea());
		em.persist(st);
	}

	@Override
	public List<StateTO> listarTodosEstados() {
		log.info("Getting all states.");

		TypedQuery<State> query = em.createQuery("from State s", State.class);
		List<State> stateList = query.getResultList();
		return convertToTO(stateList);
	}

	private List<StateTO> convertToTO(List<State> stateList) {
		return stateList.stream().map(s -> {
			StateTO st = new StateTO();
			st.setArea(s.getArea());
			st.setIbge(s.getIbge());
			st.setNome(s.getNome());
			st.setSigla(s.getSigla());
			return st;
		}).collect(Collectors.toList());
	}

}