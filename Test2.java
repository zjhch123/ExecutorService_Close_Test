import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangjiahao on 2017/2/21.
 */
public class Test2 {
    public static void main(String[] args) {
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

        service.shutdownNow();

        /*
        使用shutdownNow()，若线程中有执行sleep/wait/定时锁等，直接终止正在运行的线程并抛出interrupt异常。
        因为其内部是通过Thread.interrupt()实现的。
        这种方法有很强的局限性。因为如果线程中没有执行sleep等方法的话，其无法终止线程。
        如：Test3所示情况
         */
    }
}
