package br.inatel.dm110.ibge.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.StateTO;
import br.inatel.dm110.hello.dao.IBGEDAO;
import br.inatel.dm110.hello.entities.State;
import br.inatel.dm110.ibge.interfaces.IbgeLocal;
import br.inatel.dm110.ibge.interfaces.IbgeRemote;

@Stateless
@Remote(IbgeRemote.class)
@Local(IbgeLocal.class)
public class IbgeBean implements IbgeLocal, IbgeRemote{

	@EJB
	private IBGEDAO dao;
	
	@Override
	public void salvarEstado(StateTO state) {
		
		State st = new State();
		st.setArea(state.getArea());
		st.setIbge(state.getIbge());
		st.setNome(state.getNome());
		st.setSigla(state.getSigla());
		
		dao.insert(st);
	}
	
	@Override
	public List<StateTO> listarTodosEstados() {
		
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
