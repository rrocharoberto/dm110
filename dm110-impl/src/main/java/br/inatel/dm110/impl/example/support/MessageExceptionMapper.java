package br.inatel.dm110.impl.example.support;

import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class MessageExceptionMapper implements ExceptionMapper<MessageException> {

    @Inject
    Logger log;
    
    @Override
    public Response toResponse(MessageException exception) {
        log.log(Level.INFO, "Handling MessageException: " + exception.getMessage());

        JsonObject errorResponse = Json.createObjectBuilder()
                .add("status", Status.BAD_REQUEST.getStatusCode())
                .add("message", exception.getMessage())
                .build();

        return Response.status(Status.BAD_REQUEST)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
