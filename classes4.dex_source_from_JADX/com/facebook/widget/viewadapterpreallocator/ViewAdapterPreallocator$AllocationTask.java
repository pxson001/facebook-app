package com.facebook.widget.viewadapterpreallocator;

import com.facebook.common.executors.IncrementalRunnable;
import java.util.concurrent.ExecutorService;

/* compiled from: fecthNotificationSeenStates */
class ViewAdapterPreallocator$AllocationTask extends IncrementalRunnable {
    private final ViewAdapterPreallocator f11904a;

    public ViewAdapterPreallocator$AllocationTask(ViewAdapterPreallocator viewAdapterPreallocator, ExecutorService executorService) {
        super(executorService);
        this.f11904a = viewAdapterPreallocator;
    }

    public final void m12506b() {
        this.f11904a.g();
    }

    public final boolean m12507c() {
        return this.f11904a.h();
    }
}
