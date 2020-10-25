package state;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread VIP is coming:" + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200) {
                try {
                    thread.join(); // thread will run until finish then main thread starts again
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main:" + i);
        }

    }
}
