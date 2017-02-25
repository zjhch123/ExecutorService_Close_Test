import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangjiahao on 2017/2/21.
 */
public class Test3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable run = () -> {
            long num = 0;
            boolean flag = true;
            while(flag) {
                num += 1;
                if(num == Long.MAX_VALUE) flag = false;
            }
        };

        service.execute(run);

        service.shutdownNow();

        /*
        很多代码中都会有这样的情况，比方说使用循环标记flag循环执行一些耗时长的计算任务，
        直到满足某个条件之后才设置循环标记为false。
        如以上代码所示(循环等待的情况)，shutdownNow()无法终止线程。
        如果遇到这种情况，可以使用如Test4中的方法
         */

    }
}
