package br.inatel.dm110.ibge.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.modelmapper.ModelMapper;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;

@Stateless
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal {

	private static Logger log = Logger.getLogger(IbgeBean.class.getName());
	
	@PersistenceContext(unitName = "ibge_pu")
	private EntityManager em;
	
	@Override
	public void salvarEstado(StateTO state) {
		State entity = new State(state.getIbge(), state.getSigla(), state.getNome(), state.getArea());
		//State entity = new ModelMapper().map(state, State.class); //não mapeou o initials e o name
		log.info("Salvando estado: " + entity);
		em.persist(entity);
	}
	
	@Override
	public List<StateTO> listarTodosEstados() {
		TypedQuery<State> query = em.createQuery("from State s", State.class);
		List<State> states = query.getResultList();
		return toCollectionAPIModel(states);
	}

	private List<StateTO> toCollectionAPIModel(List<State> stateList) {
		return stateList.stream().map(s -> {
			StateTO st = new StateTO();
			st.setArea(s.getArea());
			st.setIbge(s.getIbge());
			st.setNome(s.getName());
			st.setSigla(s.getInitials());
			return st;
		}).collect(Collectors.toList());
	}
}