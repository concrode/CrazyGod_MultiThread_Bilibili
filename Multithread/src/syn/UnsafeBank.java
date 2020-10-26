package syn;

public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "Super Fund");

        Withdraw you = new Withdraw(account, 50, "you");
        Withdraw wife = new Withdraw(account, 100, "wife");

        you.start();
        wife.start();
    }
}


class Account {
    int balance;
    String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

class Withdraw extends Thread {
    Account account;
    int withdrawAmount;
    int PocketAmount;

    public Withdraw(Account account, int withdrawAmount, String name) {
        super(name);
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        if (account.balance - withdrawAmount < 0) {
            System.out.println(Thread.currentThread().getName() +"No enough balance");
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