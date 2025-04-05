package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import br.inatel.dm110.interfaces.example.TestInterface;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/teststateful")
public class TestResource {

    @Inject
    Logger log;
    
    @EJB
    TestInterface bean1;

    @EJB
    TestInterface bean2;

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testStateful() {
        log.info("Running testStateful endpoint");
        
        bean1.setValor(2);
        bean2.setValor(3);

        log.info("valor do bean1: " + bean1.getValor());
        log.info("valor do bean2: " + bean2.getValor());

		return "Teste ok.";
    }
    
}
