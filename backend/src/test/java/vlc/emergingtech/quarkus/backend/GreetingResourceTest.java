package vlc.emergingtech.quarkus.backend;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello unknown"));
    }

    @Test
    public void testHelloEndpointWithName() {
        given()
            .when()
                .get("/hello?name=test")
            .then()
                .statusCode(200)
                .body(is("Hello test"));
    }

}