package com.facebook.common.executors;

import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: service died */
public class DefaultSerialListeningExecutorService extends DefaultConstrainedListeningExecutorService implements SerialExecutorService, ListeningExecutorService {
    public DefaultSerialListeningExecutorService(Executor executor, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue(), backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
