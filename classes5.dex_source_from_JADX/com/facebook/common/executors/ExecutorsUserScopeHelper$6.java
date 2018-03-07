package com.facebook.common.executors;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.ExecutorsUserScopeHelper.NamedCallable;
import java.util.concurrent.Callable;

/* compiled from: start MediaRecorder failed */
public final class ExecutorsUserScopeHelper$6 implements NamedCallable<T>, Callable {
    final /* synthetic */ Callable f2554a;
    final /* synthetic */ ViewerContextManager f2555b;
    final /* synthetic */ ViewerContext f2556c;

    ExecutorsUserScopeHelper$6(Callable callable, ViewerContextManager viewerContextManager, ViewerContext viewerContext) {
        this.f2554a = callable;
        this.f2555b = viewerContextManager;
        this.f2556c = viewerContext;
    }

    public final String m3674a() {
        return LoggingUtils.a(this.f2554a);
    }

    public final T call() {
        this.f2555b.b(this.f2556c);
        try {
            T call = this.f2554a.call();
            return call;
        } finally {
            this.f2555b.f();
        }
    }
}
