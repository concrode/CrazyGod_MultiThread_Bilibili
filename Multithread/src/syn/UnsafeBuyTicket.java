package syn;

/**
 * Unsafe result:
 *
 * Ardbeg get 9
 * Lagavulin get 10
 * Teeling get 8
 * Ardbeg get 7
 * Teeling get 6
 * Lagavulin get 5
 * Lagavulin get 4
 * Teeling get 3
 * Ardbeg get 4
 * Teeling get 2
 * Ardbeg get 2
 * Lagavulin get 2
 * Ardbeg get 1
 * Teeling get 0
 * Lagavulin get 1
 *
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "Ardbeg").start();
        new Thread(buyTicket, "Lagavulin").start();
        new Thread(buyTicket, "Teeling").start();

    }
}

class BuyTicket implements Runnable {

    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            buy();
        }

    }

    private void buy() {
        if (ticketNums <= 0 ) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " get " + ticketNums--);

    }

}