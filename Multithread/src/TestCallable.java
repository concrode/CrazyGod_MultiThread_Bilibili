import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.downloader(url, name);
        System.out.println("Downloaded File Name(TestCallable.java):" + name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("http://oss.suning.com/snsis/channel_content/" +
                "icL3W4x74EAA17LYpFGvipFTbANy6T52BRHBqU9cWKM4YyNnnD1TnKEdAlVmZzqH.jpg?format=700w_700h_80Q", "Callable_1.jpg");
        TestCallable t2 = new TestCallable("http://oss.suning.com/snsis/channel_content/" +
                "KVc3ceRB5cibbJiUR3s-tXS4mj6BEuLMHJ-7XFQYDSQiwzbHozy0Q8Pwuicxze2x.jpg?format=700w_700h_80Q", "Callable_2.jpg");
        TestCallable t3 = new TestCallable("http://oss.suning.com/snsis/channel_content/" +
                "N6a2D0Ns3ul9cncguL7zAcYVUqDkypPebV7IdcS6p1dorHOdOlRsyCZ9Jng9MrGW.jpg?&format=700w_700h_80Q", "Callable_3.jpg");

        // Create service
        ExecutorService service = Executors.newFixedThreadPool(3);

        // Commit to execute
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);

        // Get result
        boolean result1 = r1.get();
        boolean result2 = r2.get();
        boolean result3 = r3.get();

        // Shutdown service
        service.shutdownNow();
    }
}


class WebDownloader2 {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}