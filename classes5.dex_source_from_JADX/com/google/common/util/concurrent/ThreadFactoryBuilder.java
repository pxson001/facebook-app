package com.google.common.util.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: bug_category_id */
public final class ThreadFactoryBuilder {
    public String f7679a = null;
    public Boolean f7680b = null;
    public Integer f7681c = null;
    public UncaughtExceptionHandler f7682d = null;
    public ThreadFactory f7683e = null;

    /* compiled from: bug_category_id */
    public final class C08711 implements ThreadFactory {
        final /* synthetic */ ThreadFactory f7673a;
        final /* synthetic */ String f7674b;
        final /* synthetic */ AtomicLong f7675c;
        final /* synthetic */ Boolean f7676d;
        final /* synthetic */ Integer f7677e;
        final /* synthetic */ UncaughtExceptionHandler f7678f;

        public C08711(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f7673a = threadFactory;
            this.f7674b = str;
            this.f7675c = atomicLong;
            this.f7676d = bool;
            this.f7677e = num;
            this.f7678f = uncaughtExceptionHandler;
        }

        public final Thread newThread(Runnable runnable) {
            Thread newThread = this.f7673a.newThread(runnable);
            if (this.f7674b != null) {
                newThread.setName(ThreadFactoryBuilder.m13846b(this.f7674b, Long.valueOf(this.f7675c.getAndIncrement())));
            }
            if (this.f7676d != null) {
                newThread.setDaemon(this.f7676d.booleanValue());
            }
            if (this.f7677e != null) {
                newThread.setPriority(this.f7677e.intValue());
            }
            if (this.f7678f != null) {
                newThread.setUncaughtExceptionHandler(this.f7678f);
            }
            return newThread;
        }
    }

    public static String m13846b(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }
}
