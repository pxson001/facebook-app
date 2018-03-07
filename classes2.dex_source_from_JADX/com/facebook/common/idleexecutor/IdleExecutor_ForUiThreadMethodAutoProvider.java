package com.facebook.common.idleexecutor;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: search_results */
public class IdleExecutor_ForUiThreadMethodAutoProvider extends AbstractProvider<IdleExecutor> {
    public static DefaultProcessIdleExecutor m10033b(InjectorLike injectorLike) {
        return IdleExecutorModule.m2732c(IdleExecutorFactory.m2726a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike));
    }

    public Object get() {
        return IdleExecutorModule.m2732c(IdleExecutorFactory.m2726a((InjectorLike) this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(this));
    }

    public static DefaultProcessIdleExecutor m10032a(InjectorLike injectorLike) {
        return m10033b(injectorLike);
    }
}
