package rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.concurrent.Executors;

/**
 * User: moritz
 */
@Path("async")
public class AsyncRs {

    @GET
    @Produces("text/plain")
    public void executeAsync(@Suspended final AsyncResponse as) {
        Executors.newSingleThreadExecutor().submit( new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                as.resume("Hey!");
            }
        });
    }
}
