package com.facebook.common.futures;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: isInited */
public class AlwaysSuccessfulReturnsThrowableFuture extends AbstractFuture<Object> {
    private final ListenableFuture<?> f19355a;

    /* compiled from: isInited */
    public final class C07691 implements FutureCallback<Object> {
        final /* synthetic */ AlwaysSuccessfulReturnsThrowableFuture f19356a;

        public C07691(AlwaysSuccessfulReturnsThrowableFuture alwaysSuccessfulReturnsThrowableFuture) {
            this.f19356a = alwaysSuccessfulReturnsThrowableFuture;
        }

        public final void onSuccess(@Nullable Object obj) {
            boolean a = this.f19356a.mo221a(obj);
        }

        public final void onFailure(Throwable th) {
            if (!(th instanceof CancellationException)) {
                boolean a = this.f19356a.mo221a((Object) th);
            }
        }
    }

    public AlwaysSuccessfulReturnsThrowableFuture(ListenableFuture<?> listenableFuture) {
        this.f19355a = listenableFuture;
    }

    public boolean cancel(boolean z) {
        if (super.cancel(z)) {
            return this.f19355a.cancel(z);
        }
        return false;
    }
}
