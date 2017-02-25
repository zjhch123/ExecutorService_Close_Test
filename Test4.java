import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangjiahao on 2017/2/21.
 */
public class Test4 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable run = () -> {
            long sum = 0;
            while(true && !Thread.currentThread().isInterrupted()) {
                sum += 1;
            }
        };

        service.execute(run);
        service.shutdownNow();


        /*
        对于循环等待的情况，可以引入变量Thread.currentThread().isInterrupted()来作为其中的一个判断条件
        具体可参见http://stackoverflow.com/questions/2358139/stop-an-infinite-loop-in-an-executorservice-task
        isInterrupted()方法返回当前线程是否有被interrupt
        shutdownNow()的内部实现实际上就是通过interrupt来终止线程，所以当调用shutdownNow()时，isInterrupted()会返回true
        此时就可以跳出循环等待。
        然而这也不是最优雅的解决方式，具体可以参见Test5
         */

    }
}
