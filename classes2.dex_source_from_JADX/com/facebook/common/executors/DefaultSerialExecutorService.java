package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: menu_management?page_id=%s */
public class DefaultSerialExecutorService extends ConstrainedExecutorService implements SerialExecutorService {
    public DefaultSerialExecutorService(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
