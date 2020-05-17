package vlc.emergingtech.quarkus.backend;

import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private static final String UNKNOWN_NAME = "unknown";

    GreetingService service;

    @Inject
    public GreetingResource(GreetingService greetingService) {
        this.service = greetingService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("name") Optional<String> name) {
        return service.greeting(name.orElse(UNKNOWN_NAME));
    }
}