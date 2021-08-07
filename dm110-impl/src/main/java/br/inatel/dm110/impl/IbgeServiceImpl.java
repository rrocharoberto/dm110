package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.ibge.IbgeService;
import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;

@RequestScoped
public class IbgeServiceImpl implements IbgeService {

	@EJB
	private IbgeLocal ibgeBean;

	@Override
	public void salvarEstado(StateTO state) {
		ibgeBean.salvarEstado(state);
	}

	@Override
	public List<StateTO> listarTodosEstados() {
		return ibgeBean.listarTodosEstados();
	}
}
