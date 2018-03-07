package com.facebook.quicklog.module;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: upsell_dont_warn_again */
public class SimpleBackgroundExecutor {
    public final ExecutorService f1579a;
    public final ScheduledExecutorService f1580b;

    public SimpleBackgroundExecutor(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f1579a = executorService;
        this.f1580b = scheduledExecutorService;
    }
}
