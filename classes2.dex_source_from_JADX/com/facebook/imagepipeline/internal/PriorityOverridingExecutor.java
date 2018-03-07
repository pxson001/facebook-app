package com.facebook.imagepipeline.internal;

import android.os.Process;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;

/* compiled from: orca_typing_notifications */
public class PriorityOverridingExecutor implements Executor {
    private final Executor f10839a;
    public final int f10840b;

    public PriorityOverridingExecutor(Executor executor, int i) {
        this.f10839a = executor;
        this.f10840b = i;
    }

    public void execute(final Runnable runnable) {
        ExecutorDetour.a(this.f10839a, new Runnable(this) {
            final /* synthetic */ PriorityOverridingExecutor f14530b;

            public void run() {
                int threadPriority = Process.getThreadPriority(Process.myTid());
                Process.setThreadPriority(Process.myTid(), this.f14530b.f10840b);
                try {
                    runnable.run();
                } finally {
                    Process.setThreadPriority(Process.myTid(), threadPriority);
                }
            }
        }, -1315494624);
    }
}
