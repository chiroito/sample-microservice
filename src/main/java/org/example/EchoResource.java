package org.example;

import io.smallrye.mutiny.Uni;
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
    public Uni<EchoMessage> echo(@PathParam("message") String message) {
        return Uni.createFrom().item(new EchoMessage(message));
    }
}
