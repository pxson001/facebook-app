package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: viewer_id */
public class C0061x63d21d68 extends AbstractProvider<ScheduledExecutorService> {
    public static ScheduledExecutorService m2106b(InjectorLike injectorLike) {
        return ExecutorsModule.m1715a(ThreadPoolFactory.m1885a(injectorLike), IdBasedProvider.m1811a(injectorLike, 375));
    }

    public Object get() {
        return ExecutorsModule.m1715a(ThreadPoolFactory.m1885a((InjectorLike) this), IdBasedProvider.m1811a(this, 375));
    }

    public static ScheduledExecutorService m2105a(InjectorLike injectorLike) {
        return C0061x63d21d68.m2106b(injectorLike);
    }
}
