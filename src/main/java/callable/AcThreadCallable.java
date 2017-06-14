package callable;

import cache.Cache;

import java.util.concurrent.Callable;

/**
 * Created by Ihar_Rubanovich on 6/13/2017.
 */
public class AcThreadCallable implements Callable {
    private Cache cache;

    public AcThreadCallable(Cache cache) {

    }

    @Override
    public Object call() throws Exception {
        return null;
    }


}
