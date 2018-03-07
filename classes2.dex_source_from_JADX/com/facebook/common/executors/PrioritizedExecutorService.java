package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: page/%s/admin_feed */
public interface PrioritizedExecutorService extends ExecutorService {

    /* compiled from: page/%s/admin_feed */
    public enum TaskPriority {
        LOW,
        NORMAL,
        HIGH
    }

    Executor mo2027a(TaskPriority taskPriority);
}
