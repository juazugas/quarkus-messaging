package vlc.emergingtech.quarkus.gateway;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ProxyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "ehlo";
    }

}