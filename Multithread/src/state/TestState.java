package state;

public class TestState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("/////////");
        });

        Thread.State state = thread.getState();
        System.out.println(state); // New

        thread.start();
        state = thread.getState();
        System.out.println(state); // Runnable

        while (state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(200);
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
