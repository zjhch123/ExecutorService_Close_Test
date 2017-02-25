import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangjiahao on 2017/2/15.
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable run = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("thread finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        service.execute(run);

        service.shutdown();

        service.execute(run);
        /*
        使用shutdown()，将不能继续添加等待队列。
        并且当正在执行的线程执行完毕后，才正真结束线程池。
        shutdownNow()的执行请看Test2
         */
    }
}
