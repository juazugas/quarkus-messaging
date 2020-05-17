package vlc.emergingtech.quarkus.gateway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;

@Path("/msg")
public class MessageResource {

    @Inject
    EventBus bus;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/send/{name}")
    public Uni<String> greeting (@PathParam("name") String name) {
        return bus.<String>request("greeting", name)
                    .onItem().apply(Message::body);
    }

}