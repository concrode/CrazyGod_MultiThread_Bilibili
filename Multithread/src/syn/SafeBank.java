package syn;

public class SafeBank {
    public static void main(String[] args) {
        Account2 account = new Account2(100, "Super Fund");

        Withdraw2 you = new Withdraw2(account, 50, "you");
        Withdraw2 wife = new Withdraw2(account, 100, "wife");

        you.start();
        wife.start();
    }
}


class Account2 {
    int balance;
    String name;

    public Account2(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

class Withdraw2 extends Thread {
    Account2 account;
    int withdrawAmount;
    int PocketAmount;

    public Withdraw2(Account2 account, int withdrawAmount, String name) {
        super(name);
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.balance - withdrawAmount < 0) {
                System.out.println(Thread.currentThread().getName() +" No enough balance");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.balance = account.balance - withdrawAmount;
            PocketAmount = PocketAmount + withdrawAmount;

            System.out.println(account.name + " Balance: " + account.balance);
            System.out.println(this.getName() + " Pocket Amount: " + PocketAmount);

        }
    }

}
