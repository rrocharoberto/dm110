package br.inatel.dm110.interfaces.ibge;

import java.util.List;

import br.inatel.dm110.api.ibge.StateTO;

public interface Ibge {

	void salvarEstado(StateTO state);
	
	List<StateTO> listarTodosEstados();
}
