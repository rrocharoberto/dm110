package br.inatel.dm110.ibge.beans;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;

public class IbgeBean {

	private static Logger log = Logger.getLogger(IbgeBean.class.getName());

//	private List<StateTO> toCollectionAPIModel(List<State> stateList) {
//		return stateList.stream().map(IbgeBean::toStateTO).collect(Collectors.toList());
//	}
	
//	public static StateTO toStateTO(State state) {
//		StateTO to = new StateTO();
//		to.setArea(state.getArea());
//		to.setIbge(state.getIbge());
//		to.setNome(state.getNome());
//		to.setSigla(state.getSigla());
//		return to;
//	}
}