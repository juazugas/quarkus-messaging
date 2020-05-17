package vlc.emergingtech.quarkus.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GreetingServiceTest {
    
    @Inject
    GreetingService service;

    @Test
    public void testGreeting() {
        String result = null;

        result = this.service.greeting("test");

        assertNotNull(result);
        assertEquals("Hello test", result);
    }

}