package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: square_logo */
public class C0174x6c22b08f extends AbstractProvider<ScheduledExecutorService> {
    public Object get() {
        return ExecutorsModule.f(ThreadPoolFactory.a(this), IdBasedProvider.a(this, 375));
    }
}
