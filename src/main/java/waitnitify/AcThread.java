package waitnitify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class AcThread implements Runnable {
    private final Cache cache;
    private final Lock lock;
    private final Condition condition;

    public AcThread(Cache cache) {
        this.cache = cache;
        lock = new ReentrantLock();
        condition = lock.newCondition();

    }

    @Override
    public void run() {
        lock.lock();
        try {
            cache.a();
            cache.b();
            System.out.println("a() = " + cache.getA());
            System.out.println("b() = " + cache.getB());
        } finally {
            lock.unlock();
            cache.available = true;
        }
    }
}