package vlc.emergingtech.quarkus.gateway;

import java.time.Duration;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.SseElementType;
import io.smallrye.mutiny.Multi;

/**
 * @see https://quarkus.io/guides/getting-started-reactive#handling-streams
 */
@Path("/sse")
public class SSEResource {

    @Path("/{count}")
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.TEXT_PLAIN)
    public Multi<String> eventStreams(@PathParam("count") int count, @QueryParam("name") String name) {
        return Multi.createFrom().ticks()
                    .every(Duration.ofSeconds(2))
                    .onItem()
                    .apply(n -> String.format("hello %s - %d", name, n))
                    .transform().byTakingFirstItems(count);
    }
    
}