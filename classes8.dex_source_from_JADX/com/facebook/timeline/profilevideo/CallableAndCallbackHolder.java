package com.facebook.timeline.profilevideo;

import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.Callable;

/* compiled from: mReferencedStickerData */
public class CallableAndCallbackHolder<T> {
    public final Callable<T> f9252a;
    public final FutureCallback<T> f9253b;

    public CallableAndCallbackHolder(Callable<T> callable, FutureCallback<T> futureCallback) {
        this.f9252a = callable;
        this.f9253b = futureCallback;
    }
}
