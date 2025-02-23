package br.inatel.dm110.ibge.support;

import java.util.List;
import java.util.stream.Collectors;

import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.ibge.entities.State;

public class IbgeConverter {

	public static StateTO toStateTO(State state) {
		// return new StateTO(state.getIbge(), state.getNome(), state.getSigla(), state.getArea());
		return null; //remover
	}
	
	public static State toEntity(StateTO to) {
		// return new State(to.getIbge(), to.getSigla(), to.getNome(), to.getArea());
		return null; //remover
	}

	public static List<StateTO> toTOList(List<State> stateList) {
		return stateList.stream().map(IbgeConverter::toStateTO).collect(Collectors.toList());
	}
}
