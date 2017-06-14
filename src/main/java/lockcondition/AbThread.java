package lockcondition;

import cache.Cache;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class AbThread implements Runnable {
    private final Cache cache;
    private final Lock lock;
    private final Condition condition;
    private boolean cDone;


    public AbThread(Cache cache) {
        this.cache = cache;
        lock = new ReentrantLock();
        condition = lock.newCondition();
        cDone = false;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!cache.available) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cache.c(cache.getA());
                cDone = true;
                condition.signal();
            }
        } finally {
            lock.unlock();
        }

        lock.lock();
        try {
            while (!cDone) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("smth wrong " + e.getMessage());
                }
                System.out.println("d(c+b) : c = " + cache.getC() + "b = " + cache.getB());
                cache.d(cache.getC() + cache.getB());
                condition.signal();
            }
        } finally {
            lock.unlock();
            System.out.println(cache.toString());        }
    }
}


