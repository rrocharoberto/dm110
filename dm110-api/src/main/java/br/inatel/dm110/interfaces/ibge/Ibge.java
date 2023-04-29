package br.inatel.dm110.interfaces.ibge;

import java.util.List;

import br.inatel.dm110.api.ibge.StateTO;

public interface Ibge {

	public void salvarEstado(StateTO state);
	
	public List<StateTO> listarTodosEstados();
}