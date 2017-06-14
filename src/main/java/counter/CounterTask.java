package counter;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class CounterTask {
    public static int counter = 0;

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
        System.out.println("counter = " + counter);
    }
}
/*
* output :
*
* increment cycle done count = 1537203
decrement cycle done count = 1804779
AtomicLong counter : 0 time : 84
synch counter : 0 time : 2
counter = 1804779
* */