package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: square_header_image */
public class C0175x39ac39c9 extends AbstractProvider<ScheduledExecutorService> {
    public Object get() {
        return ExecutorsModule.g(ThreadPoolFactory.a(this), IdBasedProvider.a(this, 375));
    }
}
