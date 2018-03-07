package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: tab_bar_tap */
class InProcessBatchLockState extends BatchLockState<Object> {
    private static BatchLockState f3384b;

    @ThreadSafe
    /* compiled from: tab_bar_tap */
    public class InProcessBatchLock extends BatchLock {
        @GuardedBy("this")
        private boolean f3490c = false;

        public InProcessBatchLock(BatchLockState batchLockState, Object obj) {
            super(batchLockState, obj);
        }

        public final void mo757f() {
        }

        public final void mo759h() {
        }

        public final boolean mo758g() {
            return true;
        }

        protected final synchronized void mo755d() {
            this.f3490c = true;
        }

        protected final synchronized boolean mo756e() {
            return this.f3490c;
        }
    }

    InProcessBatchLockState() {
    }

    public static synchronized BatchLockState m5598a() {
        BatchLockState batchLockState;
        synchronized (InProcessBatchLockState.class) {
            if (f3384b == null) {
                f3384b = new InProcessBatchLockState();
            }
            batchLockState = f3384b;
        }
        return batchLockState;
    }

    protected final BatchLock mo747b(Object obj) {
        return new InProcessBatchLock(this, obj);
    }
}
