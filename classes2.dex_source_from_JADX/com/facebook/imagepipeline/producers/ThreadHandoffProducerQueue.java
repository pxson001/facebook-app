package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* compiled from: orca_video_notifications */
public class ThreadHandoffProducerQueue {
    private boolean f10836a = false;
    private final Deque<Runnable> f10837b;
    private final Executor f10838c;

    public ThreadHandoffProducerQueue(Executor executor) {
        this.f10838c = (Executor) Preconditions.a(executor);
        this.f10837b = new ArrayDeque();
    }

    public final synchronized void m16059a(Runnable runnable) {
        if (this.f10836a) {
            this.f10837b.add(runnable);
        } else {
            ExecutorDetour.a(this.f10838c, runnable, -888169208);
        }
    }

    public final synchronized void m16060b(Runnable runnable) {
        this.f10837b.remove(runnable);
    }
}
