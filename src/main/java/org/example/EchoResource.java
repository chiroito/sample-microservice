package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/echo")
public class EchoResource {

    @GET
    @Path("/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public EchoMessage echo(@PathParam("message") String message) {
        return new EchoMessage(message);
    }
}
