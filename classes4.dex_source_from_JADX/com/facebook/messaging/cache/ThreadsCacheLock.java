package com.facebook.messaging.cache;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: is_followed_by_everyone */
public class ThreadsCacheLock {
    public final ReentrantReadWriteLock f10016a = new ReentrantReadWriteLock();
    private final CloseableLock f10017b = new CloseableLock(this);

    /* compiled from: is_followed_by_everyone */
    public class CloseableLock implements Closeable {
        final /* synthetic */ ThreadsCacheLock f10018a;

        public CloseableLock(ThreadsCacheLock threadsCacheLock) {
            this.f10018a = threadsCacheLock;
        }

        public void close() {
            this.f10018a.f10016a.writeLock().unlock();
        }
    }

    public final CloseableLock m10458a() {
        this.f10016a.writeLock().lock();
        return this.f10017b;
    }

    public final void m10459b() {
        Preconditions.checkState(this.f10016a.writeLock().isHeldByCurrentThread());
    }
}
