package com.facebook.common.futures;

import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;

/* compiled from: video/?id={%s} */
public abstract class AbstractDisposableFutureCallback<T> implements DisposableFutureCallback<T> {
    private volatile boolean f1260a;

    protected abstract void mo347a(T t);

    protected abstract void mo348a(Throwable th);

    public void jc_() {
        this.f1260a = true;
    }

    public final boolean ba_() {
        return this.f1260a;
    }

    public final void onSuccess(@Nullable T t) {
        if (!this.f1260a) {
            mo347a((Object) t);
        }
    }

    public final void onFailure(Throwable th) {
        if (!this.f1260a) {
            if (th instanceof CancellationException) {
                mo349a((CancellationException) th);
            } else {
                mo348a(th);
            }
        }
    }

    protected void mo349a(CancellationException cancellationException) {
    }

    public static <T> AbstractDisposableFutureCallback<T> m2442a(FutureCallback<T> futureCallback) {
        return new 1(futureCallback);
    }
}
