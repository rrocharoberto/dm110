package br.inatel.dm110.api.ibge;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
