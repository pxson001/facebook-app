package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: messenger_commerce_bubble_type */
public class C0393x59e07aec extends AbstractProvider<ScheduledExecutorService> {
    public Object get() {
        return ExecutorsModule.b(ThreadPoolFactory.a(this), IdBasedProvider.a(this, 375));
    }
}
