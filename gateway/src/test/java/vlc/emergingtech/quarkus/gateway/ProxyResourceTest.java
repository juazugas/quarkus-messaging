package vlc.emergingtech.quarkus.gateway;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import vlc.emergingtech.quarkus.gateway.api.BackendApiClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import javax.ws.rs.core.Response;

@QuarkusTest
public class ProxyResourceTest {


    @InjectMock
    @RestClient
    BackendApiClient client;

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/v1/hello")
          .then()
             .statusCode(200)
             .body(is("ehlo"));
    }

    @Test
    public void testGreetingEndpoint() throws Exception {
        doReturn(Response.ok("test").build())
            .when(client).helloGet(anyString());

        given()
            .when().get("/v1/greeting?name=test")
            .then()
                .statusCode(200)        
                .body(is("test"));
    }

}