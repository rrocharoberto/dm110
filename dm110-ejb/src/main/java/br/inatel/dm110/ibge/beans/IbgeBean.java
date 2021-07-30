package br.inatel.dm110.ibge.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.dao.IBGEDAO;
import br.inatel.dm110.ibge.entities.State;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;
import br.inatel.dm110.interfaces.ibge.IbgeRemote;

@Stateless
@Remote(IbgeRemote.class)
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal, IbgeRemote {

	private static Logger log = Logger.getLogger(IbgeBean.class.getName());

	@EJB
	private IBGEDAO dao;

	@Override
	public void salvarEstado(StateTO state) {
		log.info("Saving state: " + state);

		State st = new State();
		st.setArea(state.getArea());
		st.setIbge(state.getIbge());
		st.setNome(state.getNome());
		st.setSigla(state.getSigla());

		dao.insert(st);
	}

	@Override
	public List<StateTO> listarTodosEstados() {
		log.info("Getting all states.");

		List<State> stateList = dao.listAll();
		List<StateTO> listaTO = new ArrayList<>();

		for (State state : stateList) {
			StateTO st = new StateTO();
			st.setArea(state.getArea());
			st.setIbge(state.getIbge());
			st.setNome(state.getNome());
			st.setSigla(state.getSigla());

			listaTO.add(st);
		}
		return listaTO;
	}
}
