package com.facebook.placetips.bootstrap.fake;

import com.facebook.inject.InjectorLike;
import com.facebook.placetips.bootstrap.PlaceTipsEnabledFuture;
import com.facebook.placetips.bootstrap.PulsarDetectionEnabledFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: search_awareness_config */
public class FakeEnabledFuture extends SimpleForwardingListenableFuture<Boolean> implements PlaceTipsEnabledFuture, PulsarDetectionEnabledFuture {
    public static FakeEnabledFuture m3735a(InjectorLike injectorLike) {
        return new FakeEnabledFuture();
    }

    @Inject
    public FakeEnabledFuture() {
        super(Futures.a(Boolean.valueOf(false)));
    }
}
