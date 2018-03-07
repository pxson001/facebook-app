package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.google.common.util.concurrent.ListeningExecutorService;

/* compiled from: stack_trace_dump */
public class C0169xe970880a extends AbstractProvider<ListeningExecutorService> {
    public Object get() {
        return ExecutorsModule.e(ThreadPoolFactory.a(this), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(this), IdBasedProvider.a(this, 375), ConstrainedExecutorsStatusController.a(this));
    }
}
