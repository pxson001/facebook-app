package com.facebook.analytics2.logger;

import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.ObjectDetour;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: tab_change_action */
abstract class BatchLockState<T> {
    @GuardedBy("this")
    protected final HashMap<T, BatchLock> f3383a = new HashMap();

    @ThreadSafe
    /* compiled from: tab_change_action */
    public abstract class BatchLock {
        protected final BatchLockState f3491a;
        protected final Object f3492b;
        @GuardedBy("this")
        private int f3493c;
        @GuardedBy("this")
        private Object f3494d;

        protected abstract void mo755d();

        protected abstract boolean mo756e();

        protected abstract void mo757f();

        protected abstract boolean mo758g();

        protected abstract void mo759h();

        protected BatchLock(BatchLockState batchLockState, Object obj) {
            this.f3491a = batchLockState;
            this.f3492b = obj;
        }

        public final synchronized void m5699a() {
            this.f3493c--;
            if (this.f3493c < 0) {
                throw new IllegalStateException("Unbalance calls to acquire/release");
            } else if (this.f3493c == 0) {
                m5701b();
            }
        }

        protected void m5701b() {
            synchronized (this.f3491a) {
                this.f3491a.f3383a.remove(this.f3492b);
            }
        }

        protected final synchronized void m5703c() {
            this.f3493c++;
        }

        public final void m5700a(Object obj) {
            m5707e(obj);
            mo755d();
        }

        public final synchronized boolean m5702b(Object obj) {
            return this.f3494d == obj;
        }

        private synchronized boolean m5698i() {
            return this.f3494d != null;
        }

        public final synchronized void m5704c(Object obj) {
            m5696g(obj);
            while (m5698i()) {
                try {
                    ObjectDetour.a(this, 628492628);
                } catch (InterruptedException e) {
                }
            }
            mo757f();
            this.f3494d = obj;
        }

        private void m5696g(Object obj) {
            if (mo756e()) {
                BLog.a("BatchLockState", "Attempting to lock a deleted entry: %s (owned by %s)", new Object[]{this.f3492b, this.f3494d});
            }
            m5697h(obj);
        }

        public final synchronized boolean m5706d(Object obj) {
            boolean z;
            m5697h(obj);
            if (mo756e() || this.f3494d != null) {
                z = false;
            } else {
                z = mo758g();
                if (z) {
                    this.f3494d = obj;
                }
            }
            return z;
        }

        public final synchronized void m5707e(Object obj) {
            if (this.f3494d != obj) {
                throw new IllegalMonitorStateException("Lock is not held by the provided owner");
            }
        }

        public final synchronized void m5710f(Object obj) {
            m5707e(obj);
            try {
                mo759h();
                this.f3494d = r0;
                ObjectDetour.c(this, 359144060);
            } finally {
                this.f3494d = null;
                ObjectDetour.c(this, -1450144291);
            }
        }

        private synchronized void m5697h(Object obj) {
            if (this.f3494d == obj) {
                throw new IllegalStateException("Trying to re-enter the lock");
            }
        }

        public synchronized String toString() {
            return "[key=" + this.f3492b + ",refCount=" + this.f3493c + ",lockOwner=" + (this.f3494d != null ? this.f3494d.toString() : "null") + ",isDeleted=" + mo756e() + "]";
        }
    }

    protected abstract BatchLock mo747b(T t);

    public static BatchLockState<Object> m5595a(boolean z) {
        if (z) {
            return CrossProcessBatchLockState.a();
        }
        return InProcessBatchLockState.m5598a();
    }

    public final synchronized BatchLock m5596a(T t) {
        BatchLock batchLock;
        batchLock = (BatchLock) this.f3383a.get(t);
        if (batchLock == null) {
            batchLock = mo747b(t);
            this.f3383a.put(t, batchLock);
        }
        batchLock.m5703c();
        return batchLock;
    }

    protected BatchLockState() {
    }
}
