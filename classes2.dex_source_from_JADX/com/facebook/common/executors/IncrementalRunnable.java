package com.facebook.common.executors;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;

/* compiled from: minimum_time_between_warm_start_rerank_minutes */
public abstract class IncrementalRunnable implements Runnable {
    private ExecutorService f13454a;
    private boolean f13455b = false;

    public abstract void mo2638b();

    public abstract boolean mo2639c();

    public IncrementalRunnable(ExecutorService executorService) {
        this.f13454a = executorService;
    }

    public final void run() {
        if (!this.f13455b && mo2639c()) {
            mo2638b();
            ExecutorDetour.a(this.f13454a, this, 1072892270);
        }
    }

    public final void m19816a() {
        this.f13455b = true;
    }
}
