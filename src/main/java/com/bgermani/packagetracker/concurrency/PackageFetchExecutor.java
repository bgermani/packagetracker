package com.bgermani.packagetracker.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PackageFetchExecutor {
    @Autowired
    PackageFetchRunnable packageFetchRunnable;

    private static final Integer CORE_POOL_SIZE = 1000;
    private static final Integer MAXIMUM_POOL_SIZE = 2000;
    private static final Integer KEEPALIVE_TIME = 10;

    @Scheduled(cron = "*/5 * * * * *")
    public static void run() throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();

        // Implement RejectedExecutionHandler interface for retrying tasks
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEPALIVE_TIME,
                TimeUnit.SECONDS, blockingQueue, new ThreadPoolExecutor.AbortPolicy());

        executor.prestartAllCoreThreads();

        // Remove sample loop and map existing packages that don't have PICKED_UP status
        for (int i = 1; i <= 100; i++) {
            blockingQueue.offer(new PackageFetchRunnable("packageNumber"));
        }

        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
