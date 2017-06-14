package maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class MapsAndThreadsAnalizer {
    private Map<Integer, Integer> hashMap = new HashMap<>();
    private Map<Integer, Integer> hashMapSync = Collections.synchronizedMap(new HashMap<>());
    private Map<Integer, Integer> hashMapConcurent = new ConcurrentHashMap<Integer, Integer>();
    private int concurentSum;
    private int syncSum;
    private int sum;

    public Thread getFillHashMapThread() {
        Thread fillHashMap = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                hashMap.put(i, i);
            }
        }
        );
        return fillHashMap;
    }

    public Thread getFillHashMapSyncThread() {
        Thread fillHashMap = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                hashMapSync.put(i, i);
            }
        }
        );
        return fillHashMap;
    }

    public Thread getHashMapConcurentThread() {
        Thread fillHashMap = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                hashMapConcurent.put(i, i);
            }
        }
        );
        return fillHashMap;
    }

    public Thread getHashMapConcurentKeySum() {
        Thread fillHashMap = new Thread(() -> {

            getHashMapConcurent().forEach((k, v) -> multiSummator(k, "c"));
        }
        );
        return fillHashMap;
    }

    public Thread getHashMapSyncKeySum() {
        Thread fillHashMap = new Thread(() -> {

            getHashMapConcurent().forEach((k, v) -> multiSummator(k, "s"));
        }
        );
        return fillHashMap;
    }

    public Thread getHashMapKeySum() {
        Thread fillHashMap = new Thread(() -> {

            getHashMapConcurent().forEach((k, v) -> multiSummator(k, "h"));
        }
        );
        return fillHashMap;
    }

    private void multiSummator(int val, String type) {
        if (type.equals("h")) {
            sum = sum + val;
        }
        if (type.equals("c")) {
            concurentSum = concurentSum + val;
        }
        if (type.equals("s")) {
            syncSum = syncSum + val;
        }
    }

    public Map<Integer, Integer> getHashMap() {
        return hashMap;
    }

    public Map<Integer, Integer> getHashMapSync() {
        return hashMapSync;
    }

    public Map<Integer, Integer> getHashMapConcurent() {
        return hashMapConcurent;
    }

    public int getConcurentSum() {
        return concurentSum;
    }

    public int getSyncSum() {
        return syncSum;
    }

    public int getSum() {
        return sum;
    }
}
