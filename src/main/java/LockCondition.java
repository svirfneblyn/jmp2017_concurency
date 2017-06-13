import waitnitify.AbThread;
import waitnitify.AcThread;
import waitnitify.Cache;

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
