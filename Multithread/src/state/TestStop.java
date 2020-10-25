package state;

/**
 * 1.Use flag to stop thread
 * 2.Not recommend to use stop() or destroy() to stop thread
 */
public class TestStop implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;

        while(flag) {
            System.out.println("Run...Thread:" + i ++);
        }
    }

    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("Main:" + i);

            if (i == 900) {
                // Call function to stop thread
                testStop.stop();
                System.out.println("Thread Stops");
            }
        }
    }
}

















