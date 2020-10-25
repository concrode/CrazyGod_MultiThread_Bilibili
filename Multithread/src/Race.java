public class Race implements Runnable{

    private static String winner;


    @Override
    public void run() {
        for (int i = 0; i <= 200; i++) {

            if (Thread.currentThread().getName().equals("Rabbit") && i % 10 == 0) {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if(flag) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "-->In:" + i + " Step");
        }
    }

    private boolean gameOver(int steps) {

        if(winner != null) {
            return true;
        } else {
            if (steps >= 200) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is: " + winner);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "Rabbit").start();
        new Thread(race, "Tortoise").start();
    }



}
