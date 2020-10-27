public class DeadLock {

    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "chris");
        Makeup g2 = new Makeup(1, "Alice");

        g1.start();
        g2.start();
    }
}


class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {

    // Only one copy of resource
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    /**
     * Deadlock
     *
     * @throws InterruptedException
     */
//    private void makeup() throws InterruptedException {
//        if (choice == 0) {
//            synchronized (lipstick) {
//                System.out.println(this.girlName + " gets lipstick lock");
//                Thread.sleep(1000);
//
//                synchronized (mirror) {
//                    System.out.println(this.girlName + " gets mirror lock");
//                }
//            }
//        } else {
//            synchronized (mirror) {
//                System.out.println(this.girlName + " gets mirror lock");
//                Thread.sleep(2000);
//
//                synchronized (lipstick) {
//                    System.out.println(this.girlName + " gets lipstick lock");
//                }
//            }
//        }
//    }

    /**
     * No deadlock
     *
     * @throws InterruptedException
     */
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girlName + " gets lipstick lock");
                Thread.sleep(1000);
            }

            synchronized (mirror) {
                System.out.println(this.girlName + " gets mirror lock");
            }

        } else {
            synchronized (mirror) {
                System.out.println(this.girlName + " gets mirror lock");
                Thread.sleep(2000);
            }

            synchronized (lipstick) {
                System.out.println(this.girlName + " gets lipstick lock");
            }
        }
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}