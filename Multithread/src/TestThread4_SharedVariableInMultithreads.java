/**
 * Multithread uses one object
 *
 */
public class TestThread4_SharedVariableInMultithreads implements Runnable{

    /**
     * Lagavulin--> Get No.10 ticket
     * Jack--> Get No.9 ticket
     * Ma--> Get No.9 ticket
     * Thomas--> Get No.8 ticket
     * RoyalSolute--> Get No.7 ticket
     * Jack--> Get No.5 ticket
     * RoyalSolute--> Get No.3 ticket
     * Thomas--> Get No.4 ticket
     * Ma--> Get No.5 ticket
     * Lagavulin--> Get No.6 ticket
     * Ma--> Get No.2 ticket
     * Thomas--> Get No.0 ticket
     * RoyalSolute--> Get No.1 ticket
     * Lagavulin--> Get No.1 ticket
     * Jack--> Get No.2 ticket
     */
    // Even use static and volatile, shared variable issue still exists among multi threads
    //private static volatile int ticketNumbers = 10;

    private static int ticketNumbers = 10;


    @Override
    public void run() {
        while(true) {

            if (ticketNumbers <= 0) {
                break;
            }

            // Delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Use synchronized to avoid shared variable issue
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "--> Get No." + ticketNumbers-- + " ticket");
            }
        }
    }


    public static void main(String[] args) {
        TestThread4_SharedVariableInMultithreads t4 = new TestThread4_SharedVariableInMultithreads();

        new Thread(t4, "Jack").start();
        new Thread(t4, "Thomas").start();
        new Thread(t4, "Ma").start();
        new Thread(t4, "Lagavulin").start();
        new Thread(t4, "RoyalSolute").start();

    }
}
