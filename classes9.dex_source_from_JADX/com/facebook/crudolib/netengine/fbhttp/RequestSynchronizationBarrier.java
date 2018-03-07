package com.facebook.crudolib.netengine.fbhttp;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javax.annotation.Nullable;

/* compiled from: TincanAccept */
public class RequestSynchronizationBarrier {
    public final CountDownLatch f24074a = new CountDownLatch(1);
    @Nullable
    public volatile IOException f24075b;
    private final CountDownLatch f24076c = new CountDownLatch(1);
    @Nullable
    private volatile IOException f24077d;

    /* compiled from: TincanAccept */
    public class RequestFutureCallback implements FutureCallback<Void> {
        final /* synthetic */ RequestSynchronizationBarrier f24073a;

        public RequestFutureCallback(RequestSynchronizationBarrier requestSynchronizationBarrier) {
            this.f24073a = requestSynchronizationBarrier;
        }

        public void onSuccess(@Nullable Object obj) {
            if (this.f24073a.f24074a.getCount() != 0) {
                throw new IllegalStateException("FbHttpResponseHandler expected to count down!");
            }
        }

        public void onFailure(Throwable th) {
            this.f24073a.f24075b = RequestSynchronizationBarrier.m26020b(th);
            this.f24073a.m26021a();
        }
    }

    public final void m26021a() {
        this.f24074a.countDown();
    }

    public final void m26023b() {
        Uninterruptibles.a(this.f24074a);
        if (this.f24075b != null) {
            throw new IOException(this.f24075b);
        }
    }

    public final void m26022a(@Nullable IOException iOException) {
        this.f24077d = iOException;
        this.f24076c.countDown();
    }

    public final void m26024c() {
        Uninterruptibles.a(this.f24076c);
        if (this.f24077d != null) {
            throw new IOException(this.f24077d);
        }
    }

    public static IOException m26020b(Throwable th) {
        if (th instanceof IOException) {
            return (IOException) th;
        }
        Throwable iOException = new IOException();
        iOException.initCause(th);
        return iOException;
    }
}
