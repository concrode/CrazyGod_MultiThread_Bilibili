package state;

import java.beans.SimpleBeanInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.Counting down
 *
 * 2.Get system current time
 */
public class TestSleep2 {

    public static void tenDown() throws InterruptedException {
        int num = 10;

        while (true) {
            System.out.println(num--);
            Thread.sleep(1000);

            if (num <= 0 ) {
                break;
            }
        }
    }

    public static void main(String[] args)  {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());
        }
    }

}











