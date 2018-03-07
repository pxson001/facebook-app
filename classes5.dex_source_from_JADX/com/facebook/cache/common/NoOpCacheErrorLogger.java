package com.facebook.cache.common;

import javax.annotation.Nullable;

/* compiled from: submit_answer_prompt */
public class NoOpCacheErrorLogger implements CacheErrorLogger {
    private static NoOpCacheErrorLogger f2469a = null;

    private NoOpCacheErrorLogger() {
    }

    public static synchronized NoOpCacheErrorLogger m3588a() {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        synchronized (NoOpCacheErrorLogger.class) {
            if (f2469a == null) {
                f2469a = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = f2469a;
        }
        return noOpCacheErrorLogger;
    }

    public final void m3589a(CacheErrorLogger$CacheErrorCategory cacheErrorLogger$CacheErrorCategory, Class<?> cls, String str, @Nullable Throwable th) {
    }
}
