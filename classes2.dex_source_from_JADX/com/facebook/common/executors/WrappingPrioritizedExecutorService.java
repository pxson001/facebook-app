package com.facebook.common.executors;

import com.facebook.common.executors.PrioritizedExecutorService.TaskPriority;
import java.util.concurrent.Executor;

/* compiled from: package_name */
public abstract class WrappingPrioritizedExecutorService extends WrappingExecutorService implements PrioritizedExecutorService {
    private final PrioritizedExecutorService f10618a;

    public WrappingPrioritizedExecutorService(PrioritizedExecutorService prioritizedExecutorService) {
        super(prioritizedExecutorService);
        this.f10618a = prioritizedExecutorService;
    }

    public final Executor mo2027a(TaskPriority taskPriority) {
        return this.f10618a.mo2027a(taskPriority);
    }
}
