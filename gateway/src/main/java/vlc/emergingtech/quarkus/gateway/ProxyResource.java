package vlc.emergingtech.quarkus.gateway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import vlc.emergingtech.quarkus.gateway.api.BackendApiClient;
import vlc.emergingtech.quarkus.gateway.api.BackendApiException;

@Path("/v1")
public class ProxyResource {

    @Inject
    @RestClient
    BackendApiClient apiclient;

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "ehlo";
    }

    @Path("greeting")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response proxyGreeting (@QueryParam("name") String name) throws BackendApiException {
        return apiclient.helloGet(name);
    }

}