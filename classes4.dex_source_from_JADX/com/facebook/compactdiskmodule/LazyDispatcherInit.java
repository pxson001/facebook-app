package com.facebook.compactdiskmodule;

import com.facebook.common.init.INeedInit;
import com.facebook.compactdisk.LazyDispatcher;
import javax.inject.Inject;

/* compiled from: max_impressions */
public class LazyDispatcherInit implements INeedInit {
    private final LazyDispatcher f8194a;

    @Inject
    public LazyDispatcherInit(LazyDispatcher lazyDispatcher) {
        this.f8194a = lazyDispatcher;
    }

    public void init() {
        this.f8194a.dispatchNow();
    }
}
