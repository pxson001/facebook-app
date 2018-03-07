package com.facebook.xconfig.core;

import com.facebook.common.init.INeedInit;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: threads */
public class XConfigInitializer implements INeedInit {
    private final Lazy<XConfigStorage> f3028a;
    private final Provider<String> f3029b;

    @Inject
    public XConfigInitializer(Lazy<XConfigStorage> lazy, Provider<String> provider) {
        this.f3028a = lazy;
        this.f3029b = provider;
    }

    public void init() {
        ((XConfigStorage) this.f3028a.get()).m2701a((String) this.f3029b.get());
    }
}
