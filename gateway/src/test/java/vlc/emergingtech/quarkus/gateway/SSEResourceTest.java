package vlc.emergingtech.quarkus.gateway;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class SSEResourceTest {

    @Test
    public void testEventStreams() {
        given()
        .when().get("/sse/1?name=test")
        .then()
            .statusCode(200)
            .contentType("text/event-stream;element-type=\"text/plain\"")
            .body(containsString("data: hello test - 0"));
    }
    
}