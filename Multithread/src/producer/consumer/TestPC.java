package producer.consumer;


public class TestPC {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Producer(container).start();
        new Consumer(container).start();

    }
}


class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("Producing==> " + i + " chicken");
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Consuming---> " + container.pop().id + " Chicken");
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    /**
     * Producer is producing product
     * @param chicken
     */
    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count] = chicken;
        count++;

        this.notifyAll(); // Notify consumer to consume
    }

    /**
     * Consumer is consuming product
     * @return
     */
    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens[count];

        this.notifyAll(); // Notify producer tp produce
        return chicken;

    }
}