import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Download pictures with multithreads
 *
 */
public class TestThread2 extends Thread{

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("Downloaded File Name:" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://oss.suning.com/snsis/channel_content/" +
                "icL3W4x74EAA17LYpFGvipFTbANy6T52BRHBqU9cWKM4YyNnnD1TnKEdAlVmZzqH.jpg?format=700w_700h_80Q", "1.jpg");
        TestThread2 t2 = new TestThread2("http://oss.suning.com/snsis/channel_content/" +
                "KVc3ceRB5cibbJiUR3s-tXS4mj6BEuLMHJ-7XFQYDSQiwzbHozy0Q8Pwuicxze2x.jpg?format=700w_700h_80Q", "2.jpg");
        TestThread2 t3 = new TestThread2("http://oss.suning.com/snsis/channel_content/" +
                "N6a2D0Ns3ul9cncguL7zAcYVUqDkypPebV7IdcS6p1dorHOdOlRsyCZ9Jng9MrGW.jpg?&format=700w_700h_80Q", "3.jpg");

        t1.start();
        t2.start();
        t3.start();

    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}