public class TestThread1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("In run()------" + i);
        }
    }

    // Enter "psvm" in Intellij
    // Enter "20.for" to get for loop
    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1();

        /**
         * We can call run() method if we want but then it would behave just like a normal method and we would not be
         * able to take the advantage of multithreading. When the run method gets called though start() method then a
         * new separate thread is being allocated to the execution of run method, so if more than one thread calls
         * start() method that means their run method is being executed by separate threads
         */
        t1.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("In main()--" + i);
        }
    }
}
