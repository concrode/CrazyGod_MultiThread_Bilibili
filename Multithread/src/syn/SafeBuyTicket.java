package syn;

public class SafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket2 buyTicket = new BuyTicket2();

        new Thread(buyTicket, "Lagavulin").start();
        new Thread(buyTicket, "Ardbeg").start();
        new Thread(buyTicket, "Teeling").start();

    }
}

class BuyTicket2 implements Runnable {

    private int ticketNums = 1000;
    boolean flag = true;

    @Override
    public void run() {

        while (flag) {
            buy();
        }

    }

    private synchronized void buy() {
        if (ticketNums <= 0 ) {
            flag = false;
            return;
        }

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println(Thread.currentThread().getName() + " get " + ticketNums--);

    }

}
