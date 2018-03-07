package com.facebook.common.executors;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import java.util.concurrent.ExecutorService;

/* compiled from: service_enabled */
public class C0259xe99f8445 extends AbstractProvider<DefaultSerialListeningExecutorService> {
    public static DefaultSerialListeningExecutorService m9408b(InjectorLike injectorLike) {
        return ExecutorsModule.m1707a((ExecutorService) C0055x2995691a.m1881a(injectorLike), (BackgroundWorkLogger) BaseBackgroundWorkLogger.m1660a(injectorLike), ConstrainedExecutorsStatusController.m1909a(injectorLike));
    }

    public Object get() {
        return ExecutorsModule.m1707a((ExecutorService) C0055x2995691a.m1881a(this), (BackgroundWorkLogger) BaseBackgroundWorkLogger.m1660a((InjectorLike) this), ConstrainedExecutorsStatusController.m1909a(this));
    }

    public static DefaultSerialListeningExecutorService m9407a(InjectorLike injectorLike) {
        return C0259xe99f8445.m9408b(injectorLike);
    }
}
