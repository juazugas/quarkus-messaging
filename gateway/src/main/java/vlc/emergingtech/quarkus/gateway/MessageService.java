package vlc.emergingtech.quarkus.gateway;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class MessageService {

    @ConsumeEvent("greeting")
    public Uni<String> consumeGreeting(String message) {
        return  Uni.createFrom().item(() -> "Hello " + message);
    }

}