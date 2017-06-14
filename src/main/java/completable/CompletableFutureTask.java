package completable;

import cache.Cache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class CompletableFutureTask {

    public void runCompletableFuture() {
        Cache cache = new Cache();
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(2);
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> cache.a(), executorService)
                    .whenComplete((integer, throwable) -> cache.b())
                    .whenComplete((integer, throwable) -> cache.c(cache.getA()))
                    .whenComplete((integer, throwable) -> cache.d(cache.getC() + cache.getB()));

            int result = completableFuture.get();

            if (result > 0) {
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
