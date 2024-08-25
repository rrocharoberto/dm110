package br.inatel.dm110.impl;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import br.inatel.dm110.api.ibge.IbgeInterface;
import br.inatel.dm110.api.ibge.StateTO;
import br.inatel.dm110.interfaces.ibge.IbgeLocal;

@RequestScoped
@Path("/ibge")
public class IbgeResource implements IbgeInterface {

	// @EJB
	// private IbgeLocal ibgeBean;

	// @POST
	// @Path("/state")
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Override
	// public void salvarEstado(StateTO state) {
	// 	ibgeBean.salvarEstado(state);
	// }

	// @GET
	// @Path("/state")
	// @Produces(MediaType.APPLICATION_JSON)
	// @Override
	// public List<StateTO> listarTodosEstados() {
	// 	return ibgeBean.listarTodosEstados();
	// }
}
