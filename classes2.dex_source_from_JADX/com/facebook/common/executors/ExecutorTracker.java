package com.facebook.common.executors;

import com.google.common.annotations.VisibleForTesting;
import java.util.WeakHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: voip_use_jni_audio_caller_android */
public class ExecutorTracker {
    private static final WeakHashMap<ThreadPoolExecutor, Void> f943a = new WeakHashMap();

    @Deprecated
    @VisibleForTesting
    public static synchronized <T extends ThreadPoolExecutor> T m1908a(T t) {
        synchronized (ExecutorTracker.class) {
            f943a.put(t, null);
        }
        return t;
    }
}
