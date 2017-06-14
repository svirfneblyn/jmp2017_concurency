package counter;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class DecrementatorThread implements Runnable {
    private int stop = 1000000;
    @Override
    public void run() {
        for (int i = 0; i < stop; i++ ){
            CounterHolder.counter--;
        }
        System.out.println("decrement cycle done count = " + CounterHolder.counter);
    }
}
