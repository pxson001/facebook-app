package com.facebook.common.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: maybeStartAndRegister called in wrong state. triedBindingLocally= */
public class CallerThreadExecutor extends AbstractExecutorService {
    public static final CallerThreadExecutor f14746a = new CallerThreadExecutor();

    public static CallerThreadExecutor m21153a() {
        return f14746a;
    }

    private CallerThreadExecutor() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }

    public boolean isShutdown() {
        return false;
    }

    public void shutdown() {
    }

    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }

    public boolean isTerminated() {
        return false;
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return true;
    }
}
