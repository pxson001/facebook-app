package com.facebook.common.futures;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: end_to_end */
public class SharedFutureHolder<V> {
    public final ListenableFuture<V> f13008a;
    public final AtomicInteger f13009b = new AtomicInteger();
    public volatile boolean f13010c;

    /* compiled from: end_to_end */
    public class SharedFuture extends AbstractFuture<V> {
        public boolean f13014a;
        final /* synthetic */ SharedFutureHolder f13015b;
        private final FutureCallback<V> f13016c = new C06221(this);
        private final Runnable f13017d = new C06232(this);

        /* compiled from: end_to_end */
        class C06221 implements FutureCallback<V> {
            final /* synthetic */ SharedFuture f13020a;

            C06221(SharedFuture sharedFuture) {
                this.f13020a = sharedFuture;
            }

            public void onSuccess(V v) {
                boolean a = this.f13020a.a(v);
            }

            public void onFailure(Throwable th) {
                if (this.f13020a.f13015b.f13008a.isCancelled()) {
                    Preconditions.checkState(th instanceof CancellationException, "Inconsistent underlying state: isCancelled()=true, but t=" + th);
                    this.f13020a.cancel(false);
                    return;
                }
                boolean a = this.f13020a.a(th);
            }
        }

        /* compiled from: end_to_end */
        class C06232 implements Runnable {
            final /* synthetic */ SharedFuture f13021a;

            C06232(SharedFuture sharedFuture) {
                this.f13021a = sharedFuture;
            }

            public void run() {
                int decrementAndGet = this.f13021a.f13015b.f13009b.decrementAndGet();
                if (this.f13021a.isCancelled() && decrementAndGet == 0) {
                    this.f13021a.f13015b.f13008a.cancel(this.f13021a.f13015b.f13010c);
                }
            }
        }

        public SharedFuture(SharedFutureHolder sharedFutureHolder, boolean z) {
            this.f13015b = sharedFutureHolder;
            this.f13014a = z;
            sharedFutureHolder.f13009b.incrementAndGet();
            Futures.a(sharedFutureHolder.f13008a, this.f13016c, MoreExecutors.a());
            a(this.f13017d, MoreExecutors.a());
        }

        public boolean cancel(boolean z) {
            if (z) {
                this.f13015b.f13010c = true;
            }
            return super.cancel(z);
        }
    }

    public SharedFutureHolder(ListenableFuture<V> listenableFuture) {
        this.f13008a = listenableFuture;
    }

    public final ListenableFuture<V> m13870a(boolean z) {
        return new SharedFuture(this, z);
    }
}
