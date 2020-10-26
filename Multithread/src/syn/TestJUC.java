package syn;

import java.util.concurrent.CopyOnWriteArrayList;

public class TestJUC {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(copyOnWriteArrayList.size());
    }
}
