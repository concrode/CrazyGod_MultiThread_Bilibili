package syn;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        /**
         * Make it thread safe
         */
//       for (int i = 0; i < 300000; i++) {
//            new Thread(() -> {
//                synchronized (list) {
//                    list.add(Thread.currentThread().getName());
//                }
//            }).start();
//        }

        for (int i = 0; i < 300000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}


