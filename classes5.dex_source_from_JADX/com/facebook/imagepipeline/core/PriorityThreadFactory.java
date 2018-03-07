package com.facebook.imagepipeline.core;

import android.os.Process;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import java.util.concurrent.ThreadFactory;

/* compiled from: TRANSIT_STOP */
public class PriorityThreadFactory implements ThreadFactory {
    public final int f13698a;

    public PriorityThreadFactory(int i) {
        this.f13698a = i;
    }

    public Thread newThread(final Runnable runnable) {
        return ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ PriorityThreadFactory f13697b;

            public void run() {
                try {
                    Process.setThreadPriority(this.f13697b.f13698a);
                } catch (Throwable th) {
                }
                runnable.run();
            }
        }, 1960318748);
    }
}
