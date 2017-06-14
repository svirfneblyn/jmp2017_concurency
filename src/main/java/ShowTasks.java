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

        abThread.start();
        acThread.start();
        fe.executeFutureWorkers();
        completableFutureTask.runCompletableFuture();

        mapsTaskExecute();

    }

    public static void mapsTaskExecute() {

        MapsAndThreadsAnalizer maps = new MapsAndThreadsAnalizer();

        maps.getFillHashMapSyncThread().start();
        maps.getHashMapConcurentThread().start();
        maps.getFillHashMapThread().start();

        maps.getHashMapConcurentKeySumatorThread().start();
        maps.getHashMapKeySumatorThread().start();
        maps.getHashMapSyncKeySumatorThread().start();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hash map key sum :" + maps.getSum() + "Sync Hash map key sum : " + maps.getSyncSum()
                                   + " Concurent key sum : + " + maps.getConcurentSum());
    }
}
