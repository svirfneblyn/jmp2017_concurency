/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class ConcurrencyApplication {
    static int a;
    static int b;
    static int c;
    static int d;

    public static void main(String[] args) {
        Thread aThread = new Thread() {
            @Override
            public void run() {
                synchronized (this) {
                    a();
                    b();
                    System.out.format("a = %d b =%d",a,b);
                }
            }
        };

        Thread bThread = new Thread() {

            @Override
            public void run() {
                synchronized (this) {
                    while (a == 0) {
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    c(a);
                    notifyAll();
                }
                synchronized (this) {
                    while (b == 0) {
                        try {
                            wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    d(c + b);
                    notifyAll();
                    System.out.format("a=%d b=%d c=%d d=%d\n", a, b, c, d);
                }
            }
        };
        aThread.start();
        bThread.start();

    }


    private static int d(int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d = i / 4;
        System.out.println("d() = " + d);
        return d;
    }

    private static int b() {
        try {
            Thread.sleep(100);
            b = 4;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b() " + b);
        return b;
    }

    private static int a() {
        try {
            Thread.sleep(100);
            a = 1;
            System.out.println("a() = " + a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }

    private static int c(int a) {
        c = a * 10;
        System.out.println("c()=  " + c);
        return c;

    }
}

