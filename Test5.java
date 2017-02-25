import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjiahao on 2017/2/25.
 */
public class Test5 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable run = () -> {
            long sum = 0;
            boolean flag = true;
            while(flag && !Thread.currentThread().isInterrupted()) {
                sum += 1;
                if(sum == Long.MAX_VALUE) flag = false;
            }
        };

        service.execute(run);

        service.shutdown();

        try {
            if(!service.awaitTermination(2, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

        /*
        这里。先调用shutdown()使线程池状态改变为SHUTDOWN，线程池不允许继续添加线程，并且等待正在执行的线程返回。
        调用awaitTermination设置定时任务，代码内的意思为2s后检测线程池内的线程是否均执行完毕，若没有，则调用shutdownNow()方法
         */


    }
}
