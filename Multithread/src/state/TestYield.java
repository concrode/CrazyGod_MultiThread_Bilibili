package state;

/**
 * Yiled may not be successfully. Depends on CPU
 *
 * If not successful, then printout:
 *                     a Thread start..
 *                     a Thread stop..
 *                     b Thread start..
 *                     b Thread stop..
 *
 */
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }

}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread start..");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " Thread stop..");

    }
}