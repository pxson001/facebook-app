package com.facebook.zero.iptest;

import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: events_permalink_scroll */
public class ZeroIPTestInvoker {
    public final ZeroIPTestManager f13063a;
    public final DefaultAppChoreographer f13064b;
    public final Provider<Boolean> f13065c;
    public final ZeroIPTestScheduler f13066d;

    /* compiled from: events_permalink_scroll */
    public class C18221 implements Runnable {
        final /* synthetic */ ZeroIPTestInvoker f13062a;

        public C18221(ZeroIPTestInvoker zeroIPTestInvoker) {
            this.f13062a = zeroIPTestInvoker;
        }

        public void run() {
            if (((Boolean) this.f13062a.f13065c.get()).booleanValue()) {
                ZeroIPTestManager zeroIPTestManager = this.f13062a.f13063a;
                if (!zeroIPTestManager.f13069a.v() && zeroIPTestManager.f13074f.a()) {
                    zeroIPTestManager.m13139b();
                }
                return;
            }
            this.f13062a.f13066d.a();
        }
    }

    @Inject
    public ZeroIPTestInvoker(AppChoreographer appChoreographer, ZeroIPTestManager zeroIPTestManager, ZeroIPTestScheduler zeroIPTestScheduler, Provider<Boolean> provider) {
        this.f13064b = appChoreographer;
        this.f13063a = zeroIPTestManager;
        this.f13065c = provider;
        this.f13066d = zeroIPTestScheduler;
    }
}
