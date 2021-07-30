package br.inatel.dm110.api.ibge;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ibge")
public interface IbgeService {

	@POST
	@Path("/state")
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvarEstado(StateTO state);
	
	@GET
	@Path("/states")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StateTO> listarTodosEstados();
	
}
