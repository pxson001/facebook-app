package com.facebook.messaging.clockskew;

import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.debug.log.BLog;
import java.util.concurrent.Callable;

/* compiled from: messenger_pay_theme */
class ClockSkewCheckBackgroundTask$1 implements Callable<BackgroundResult> {
    final /* synthetic */ ClockSkewCheckBackgroundTask f9766a;

    ClockSkewCheckBackgroundTask$1(ClockSkewCheckBackgroundTask clockSkewCheckBackgroundTask) {
        this.f9766a = clockSkewCheckBackgroundTask;
    }

    public Object call() {
        try {
            this.f9766a.b.a();
            ClockSkewCheckBackgroundTask.a(this.f9766a, this.f9766a.a.a() + 86400000);
            ClockSkewCheckBackgroundTask.b(this.f9766a, 0);
            return new BackgroundResult(true);
        } catch (Throwable e) {
            if (this.f9766a.g == 0) {
                ClockSkewCheckBackgroundTask.b(this.f9766a, 60000);
            } else {
                ClockSkewCheckBackgroundTask.b(this.f9766a, Math.min(this.f9766a.g * 2, 28800000));
            }
            ClockSkewCheckBackgroundTask.a(this.f9766a, this.f9766a.a.a() + this.f9766a.g);
            BLog.b("ClockSkewCheckBackgroundTask", e, "Failed to check clock skew, scheduling next retry time to %d ms later", new Object[]{Long.valueOf(this.f9766a.g)});
            throw e;
        }
    }
}
