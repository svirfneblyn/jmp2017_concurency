package counter;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class IncrementatorThread implements Runnable {
    private int stop = 1000000;
    @Override
    public void run() {
        for (int i = 0; i < stop; i++ ){
            CounterTask.counter++;
        }
        System.out.println("increment cycle done count = " + CounterTask.counter );

    }
}
