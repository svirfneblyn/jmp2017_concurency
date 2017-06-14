import counter.CounterHolder;
import counter.DecrementatorThread;
import counter.IncrementatorThread;
import counter.SynchronizedCounter;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class CounterTaskDemo {

    public static void main(String[] args) {
        Thread incrementator = new Thread(new IncrementatorThread());
        Thread decrementator = new Thread(new DecrementatorThread());
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        incrementator.start();
        decrementator.start();
        syncCounter.getDecrementatorThread().start();
        syncCounter.getIncrementatorThread().start();
        syncCounter.getAtomicIncrementatorThread().start();
        syncCounter.getAtomicDecrementatorThread().start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AtomicLong counter : " + syncCounter.getAtomicLongCounter() + " time : " + syncCounter.getAtomicCounterTime());
        System.out.println("synch counter : " + syncCounter.getCounter() + " time : " + syncCounter.getSyncCounterTime());
        System.out.println("counter = " + CounterHolder.counter);
    }
}
/*
* output :
*
* increment cycle done count = 1537203
decrement cycle done count = 1804779
AtomicLong counter : 0 time : 110
synch counter : 0 time : 120
counter = 1804779
* */