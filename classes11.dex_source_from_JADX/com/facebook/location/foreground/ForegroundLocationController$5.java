package com.facebook.location.foreground;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;

/* compiled from: Unknown error occurred */
public class ForegroundLocationController$5 extends AbstractDisposableFutureCallback<OperationResult> {
    final /* synthetic */ ForegroundLocationController f10434a;

    public ForegroundLocationController$5(ForegroundLocationController foregroundLocationController) {
        this.f10434a = foregroundLocationController;
    }

    protected final void m10835a(Object obj) {
        this.f10434a.m.a.a(ForegroundLocationAnalyticsLogger.a("foreground_location_pingback_success"));
    }

    protected final void m10836a(Throwable th) {
        this.f10434a.m.a.a(ForegroundLocationAnalyticsLogger.a("foreground_location_pingback_failure").a("throwable_class", th.getClass()));
    }
}
