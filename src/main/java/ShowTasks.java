import cache.Cache;
import completable.CompletableFutureTask;
import futureexecutor.FutureAndExecutor;
import lockcondition.AbThread;
import lockcondition.AcThread;
import maps.MapsAndThreadsAnalizer;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class ShowTasks {

    public static void main(String[] args) {
        FutureAndExecutor fe = new FutureAndExecutor();
        CompletableFutureTask completableFutureTask = new CompletableFutureTask();
        Cache cache = new Cache();
        Thread abThread = new Thread(new AbThread(cache));
        Thread acThread = new Thread(new AcThread(cache));
        MapsAndThreadsAnalizer maps = new MapsAndThreadsAnalizer();

        maps.getFillHashMapSyncThread().start();
        maps.getHashMapConcurentThread().start();
        maps.getHashMapSyncKeySum().start();
        maps.getFillHashMapThread().start();
        maps.getHashMapKeySum();

        abThread.start();
        acThread.start();
        fe.executeFutureWorkers();
        completableFutureTask.runCompletableFuture();

    }

  }
