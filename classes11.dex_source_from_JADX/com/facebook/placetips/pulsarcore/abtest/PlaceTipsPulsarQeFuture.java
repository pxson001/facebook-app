package com.facebook.placetips.pulsarcore.abtest;

import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQe.Config;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

/* compiled from: The card's parent must be a ViewGroup to access the LayoutTransition object */
public class PlaceTipsPulsarQeFuture extends ForwardingListenableFuture<Config> {
    private final ListenableFuture<Config> f10690a = Futures.a(new Config(false, null, 0, 0, 0, 0, 0, 0));

    protected final /* synthetic */ Future m11193a() {
        return m11194b();
    }

    protected final /* synthetic */ Object m11195e() {
        return m11194b();
    }

    protected final ListenableFuture<Config> m11194b() {
        return this.f10690a;
    }
}
