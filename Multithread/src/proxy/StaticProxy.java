package proxy;

/**
 * Static proxy
 *
 */
public class StaticProxy {

    public static void main(String[] args) {

        new Thread( () -> System.out.println("Hi, new thread")).start();

        new WeddingCompany(new You()).happyMarry();
//        WeddingCompany w = new WeddingCompany(new You());
//        w.happyMarry();

    }
}

/**
 * Needs to be implemented by both proxy and real subject classes
 *
 */
interface Marry {
    void happyMarry();
}

/**
 * Real subject class
 *
 */
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("I am getting married");
    }
}

/**
 * Proxy class
 */
class WeddingCompany implements Marry {

    private Marry target;

    // Any class implementing Marry interface can be passed as variable here
    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("After marriage---");
    }

    private void before() {
        System.out.println("Before marriage---");
    }
}