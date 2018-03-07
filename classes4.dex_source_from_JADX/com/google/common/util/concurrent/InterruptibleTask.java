package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@GwtCompatible
/* compiled from: end_vault_upload */
public abstract class InterruptibleTask implements Runnable {
    private static final AtomicReferenceFieldUpdater<InterruptibleTask, Thread> f13003a = AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "b");
    public volatile Thread f13004b;
    public volatile boolean f13005c;

    abstract void mo936a();

    abstract boolean mo937b();

    InterruptibleTask() {
    }

    public final void run() {
        if (f13003a.compareAndSet(this, null, Thread.currentThread())) {
            try {
                mo936a();
                if (mo937b()) {
                    while (!this.f13005c) {
                        Thread.yield();
                    }
                }
            } catch (Throwable th) {
                if (mo937b()) {
                    while (!this.f13005c) {
                        Thread.yield();
                    }
                }
            }
        }
    }
}
