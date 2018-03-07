package com.facebook.zero.iptest;

import com.facebook.common.init.INeedInit;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: last_updated_time */
public class ZeroIPTestInitializer implements INeedInit {
    private final ZeroIPTestScheduler f9527a;
    private final Provider<Boolean> f9528b;

    @Inject
    public ZeroIPTestInitializer(ZeroIPTestScheduler zeroIPTestScheduler, Provider<Boolean> provider) {
        this.f9527a = zeroIPTestScheduler;
        this.f9528b = provider;
    }

    public void init() {
        if (((Boolean) this.f9528b.get()).booleanValue()) {
            this.f9527a.m9911b();
        }
    }
}
