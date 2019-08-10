package br.inatel.dm110.hello.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.hello.dao.IBGEDAO;
import br.inatel.dm110.hello.entities.State;
import br.inatel.dm110.ibge.interfaces.IBGELocal;
import br.inatel.dm110.ibge.interfaces.IBGERemote;
import br.inatel.dm110.ibge.to.StateTO;

@Stateless
@Remote(IBGERemote.class)
@Local(IBGELocal.class)
public class IBGEBean implements IBGERemote, IBGELocal {

	@EJB
	private IBGEDAO dao;
	
	@Override
	public void createState(StateTO state) {
		State st = new State();
		st.setArea(state.getArea());
		st.setIbge(state.getIbge());
		st.setNome(state.getNome());
		st.setSigla(state.getSigla());
		dao.insert(st);
	}
	
	@Override
	public List<StateTO> listAllStates() {
		ArrayList<StateTO> list = new ArrayList<>();
		for (State st : dao.listAll()) {
			StateTO to = new StateTO();
			to.setArea(st.getArea());
			to.setIbge(st.getIbge());
			to.setNome(st.getNome());
			to.setSigla(st.getSigla());
			list.add(to);
		}
		return list;
	}
}
