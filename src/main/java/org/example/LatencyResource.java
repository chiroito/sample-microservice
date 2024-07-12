package org.example;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.Duration;

@Path("/latency")
public class LatencyResource {

    @GET
    @Path("/ms/{ms}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<EchoMessage> lateMs(@PathParam("ms") int ms) {
        return createUni().onItem().delayIt().by(Duration.ofMillis(ms));
    }

    @GET
    @Path("/s/{s}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<EchoMessage> lateS(@PathParam("s") int s) {
        return createUni().onItem().delayIt().by(Duration.ofSeconds(s));
    }


    private Uni<EchoMessage> createUni(){
        return Uni.createFrom().item(new EchoMessage("Hello"));
    }
}
