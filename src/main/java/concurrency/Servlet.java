package concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: moritz
 */
@WebServlet("/con")
public class Servlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Servlet.class);

    @Resource
    ManagedExecutorService executorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Callable<Integer>> runs = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int id = i;
            Callable<Integer> temp = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    logger.info("Hallo aus der Ausführung " + id);
                    return 1000 + id;
                }
            };
            runs.add(temp);
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(runs);
            for (Future<Integer> future : futures) {
                Integer integer = future.get();
                logger.info(integer.toString());
            }
        } catch (InterruptedException e) {
            logger.error("Interrupt", e);
        } catch (ExecutionException e) {
            logger.error("Execution", e);
        }
    }

}
