package lockcondition;

import cache.Cache;
import lockcondition.AbThread;
import lockcondition.AcThread;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class LockCondition {
    public static void main(String[] args) {
        Cache cache = new Cache();
        Thread abThread = new Thread(new AbThread(cache));
        Thread acThread = new Thread(new AcThread(cache));
        abThread.start();
        acThread.start();
    }
}
