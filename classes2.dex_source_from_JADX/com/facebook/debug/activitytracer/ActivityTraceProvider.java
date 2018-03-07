package com.facebook.debug.activitytracer;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.debug.tracer.AsyncTracer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: video_state */
public class ActivityTraceProvider extends AbstractAssistedProvider<ActivityTrace> {
    public final ActivityTrace m2220a(AsyncTracer asyncTracer, String str) {
        return new ActivityTrace(DefaultAndroidThreadUtil.m1646b((InjectorLike) this), asyncTracer, str);
    }
}
