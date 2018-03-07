package com.facebook.common.appchoreographer;

import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import java.util.concurrent.Callable;

/* compiled from: strategy */
public class DefaultAppChoreographer$4 implements Callable<T> {
    final /* synthetic */ Priority f2480a;
    final /* synthetic */ String f2481b;
    final /* synthetic */ Callable f2482c;
    final /* synthetic */ DefaultAppChoreographer f2483d;

    public DefaultAppChoreographer$4(DefaultAppChoreographer defaultAppChoreographer, Priority priority, String str, Callable callable) {
        this.f2483d = defaultAppChoreographer;
        this.f2480a = priority;
        this.f2481b = str;
        this.f2482c = callable;
    }

    public T call() {
        TracerDetour.a("AppChoreographer(p%s)/%s", new Object[]{Integer.valueOf(this.f2480a.ordinal()), this.f2481b}, 1515647772);
        LoomLogger.a(LoomLoggerDetour.a(-1721619175), String.valueOf(this.f2480a.ordinal()), this.f2481b);
        try {
            T call = this.f2482c.call();
            return call;
        } finally {
            TracerDetour.a(-2089860109);
        }
    }
}
