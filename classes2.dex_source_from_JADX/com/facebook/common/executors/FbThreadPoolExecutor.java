package com.facebook.common.executors;

import com.facebook.debug.log.BLog;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: use_signal_neighbor_cell */
public class FbThreadPoolExecutor extends ThreadPoolExecutor {
    private final BackgroundWorkLogger f1500a;

    public FbThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, BackgroundWorkLogger backgroundWorkLogger) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.f1500a = backgroundWorkLogger;
    }

    public void execute(Runnable runnable) {
        super.execute(LoggingRunnable.m12548a(runnable, this.f1500a, "FbThreadPoolExecutor"));
    }

    @Deprecated
    public void shutdown() {
        Throwable exception = new Exception();
        exception.fillInStackTrace();
        BLog.c(getClass(), exception, "should never shut down %s", new Object[]{getClass().getName()});
        super.shutdown();
    }

    @Deprecated
    public List<Runnable> shutdownNow() {
        Throwable exception = new Exception();
        exception.fillInStackTrace();
        BLog.c(getClass(), exception, "should never shut down %s", new Object[]{getClass().getName()});
        return super.shutdownNow();
    }
}
