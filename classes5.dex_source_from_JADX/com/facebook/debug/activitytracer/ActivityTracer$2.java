package com.facebook.debug.activitytracer;

import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.debug.tracer.TracerClock;

/* compiled from: search_ranking */
public class ActivityTracer$2 implements Runnable {
    final /* synthetic */ ActivityTracer f2887a;

    public ActivityTracer$2(ActivityTracer activityTracer) {
        this.f2887a = activityTracer;
    }

    public void run() {
        if (this.f2887a.g != null) {
            long a;
            ActivityTrace activityTrace = this.f2887a.g;
            AsyncTracer asyncTracer = activityTrace.b;
            if (asyncTracer.e == -1) {
                a = (TracerClock.a() - asyncTracer.c) / 1000000;
            } else {
                a = (asyncTracer.e - asyncTracer.c) / 1000000;
            }
            activityTrace.m = a;
            ActivityTracer.a(this.f2887a, "draw");
        }
    }
}
