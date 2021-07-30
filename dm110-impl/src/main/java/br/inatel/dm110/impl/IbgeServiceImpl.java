package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.ibge.IbgeService;
import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.interfaces.ibge.IbgeRemote;

@RequestScoped
public class IbgeServiceImpl implements IbgeService {

	@EJB(lookup = "ejb:dm110-ear-1.0/dm110-ejb-1.0/IbgeBean!br.inatel.dm110.ibge.interfaces.IbgeRemote")
	private IbgeRemote ibgeBean;

	@Override
	public void salvarEstado(StateTO state) {
		ibgeBean.salvarEstado(state);
	}

	@Override
	public List<StateTO> listarTodosEstados() {
		return ibgeBean.listarTodosEstados();
	}

}
