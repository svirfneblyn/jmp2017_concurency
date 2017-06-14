package cache;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class Cache {
    private int a;
    private int b;
    private int c;
    private int d;

    public volatile boolean available;


    public Cache() {
        available = false;
    }

    public int a() {
        try {
            Thread.sleep(100);
            setA(1);
            System.out.println("a() = " + getA());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("a() setted a  = " + getA());
            return getA();
        }
    }

    public int c(int a) {
        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            int result = a * 10;
            setC(result);
            System.out.println("c()=  " + getC());
            return getC();
        }
    }

    public int d(int i) {
        setD(i);
        System.out.println("d() = " + getD());
        return getD();
    }

    public int b() {
        setB(4);
        System.out.println("b() " + getB());
        return getB();
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "a =" + a + "b = " + b + " c =" + c+ " d = " + d;
    }
}
