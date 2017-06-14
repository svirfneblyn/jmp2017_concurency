package futureexecutor;

import cache.Cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class FutureAndExecutor {

    public void executeFutureWorkers() {
        Cache cache = new Cache();
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(2);
            Future<Integer> aFuture = executorService.submit(cache::a);
            Future<Integer> bFuture = executorService.submit(cache::b);
            Future<Integer> cFuture = executorService.submit(() -> cache.c(aFuture.get()));
            Future<Integer> dFuture = executorService.submit(() -> cache.d(cFuture.get() + bFuture.get()));


            if (dFuture.get() > 0) {
                System.out.println(cache.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
