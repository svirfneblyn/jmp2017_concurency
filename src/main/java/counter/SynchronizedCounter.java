package counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class SynchronizedCounter {
    private int counter;
    private AtomicLong atomicLongCounter = new AtomicLong();
    private Long atomicIncrTime;
    private Long atomicDecrTime;
    private Long syncIncrTime;
    private Long syncDecrTime;

    public static final Object obj = new Object();

    public Thread getIncrementatorThread() {
        Thread incrementatorThread = new Thread(() -> {
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                synchronized (obj) {
                    counter++;
                }
            }
            Long end = System.currentTimeMillis();
            syncIncrTime = end - start;
        }
        );
        return incrementatorThread;
    }

    public Thread getDecrementatorThread() {
        Thread decrementatorThread = new Thread(() -> {
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                synchronized (obj) {
                    counter--;
                }
            }
            Long end = System.currentTimeMillis();
            syncDecrTime = start - end;
        }
        );
        return decrementatorThread;
    }

    public Thread getAtomicDecrementatorThread() {
        Thread decrementatorThread = new Thread(() -> {
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                atomicLongCounter.decrementAndGet();
            }
            Long end = System.currentTimeMillis();
            atomicDecrTime = end - start;
        }
        );
        return decrementatorThread;
    }

    public Thread getAtomicIncrementatorThread() {
        Thread incrementatorThread = new Thread(() -> {
            Long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                atomicLongCounter.incrementAndGet();
            }
            Long end = System.currentTimeMillis();
            atomicIncrTime = end - start;
        }
        );
        return incrementatorThread;
    }

    public int getCounter() {
        return counter;
    }

    public AtomicLong getAtomicLongCounter() {
        return atomicLongCounter;
    }

    public Long getSyncCounterTime() {
        return syncIncrTime + syncDecrTime;
    }

    public Long getAtomicCounterTime() {
        return atomicIncrTime + atomicDecrTime;
    }
}
