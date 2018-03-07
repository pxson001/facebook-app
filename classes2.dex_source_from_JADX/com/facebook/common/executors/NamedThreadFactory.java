package com.facebook.common.executors;

import android.os.Process;
import com.facebook.systrace.SystraceMetadata;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: vote_count */
public class NamedThreadFactory implements ThreadFactory {
    private final String f940a;
    public final int f941b;
    private final AtomicInteger f942c;

    public NamedThreadFactory(String str, ThreadPriority threadPriority) {
        this(str, threadPriority.getAndroidThreadPriority());
    }

    public NamedThreadFactory(String str, int i) {
        this.f942c = new AtomicInteger(1);
        this.f940a = str;
        this.f941b = i;
    }

    public Thread newThread(final Runnable runnable) {
        return ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ NamedThreadFactory f1486b;

            public void run() {
                SystraceMetadata.c();
                try {
                    Process.setThreadPriority(this.f1486b.f941b);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        }, this.f940a + this.f942c.getAndIncrement(), -1120004315);
    }
}
