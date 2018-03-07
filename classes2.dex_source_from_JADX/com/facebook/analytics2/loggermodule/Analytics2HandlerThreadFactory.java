package com.facebook.analytics2.loggermodule;

import android.content.Context;
import android.os.HandlerThread;
import com.facebook.analytics2.logger.HandlerThreadFactory;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;

/* compiled from: task_fetch_questions */
public class Analytics2HandlerThreadFactory implements HandlerThreadFactory, InjectableComponentWithoutContext {
    public FbHandlerThreadFactory f3160a;

    public static void m5322a(Object obj, Context context) {
        ((Analytics2HandlerThreadFactory) obj).f3160a = FbHandlerThreadFactory.m3575a(FbInjector.get(context));
    }

    public Analytics2HandlerThreadFactory(Context context) {
        Class cls = Analytics2HandlerThreadFactory.class;
        m5322a((Object) this, context);
    }

    public final HandlerThread mo735a(String str) {
        return this.f3160a.m3579a(str);
    }

    public final HandlerThread mo736a(String str, int i) {
        return this.f3160a.m3580a(str, ThreadPriority.getClosestThreadPriorityFromAndroidThreadPriority(i));
    }
}
