package lee.com.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: lidong
 * Date: 2025/3/10 14:50
 */
public class TimeServerHandlerExecutePool {

    private final ExecutorService exec;


    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        exec = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        exec.execute(task);
    }



}
