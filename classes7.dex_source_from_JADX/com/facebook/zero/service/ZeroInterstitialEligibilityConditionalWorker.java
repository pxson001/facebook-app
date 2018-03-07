package com.facebook.zero.service;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: width/ */
public class ZeroInterstitialEligibilityConditionalWorker implements ConditionalWorker {
    private final ZeroInterstitialEligibilityManager f229a;

    public static ZeroInterstitialEligibilityConditionalWorker m232b(InjectorLike injectorLike) {
        return new ZeroInterstitialEligibilityConditionalWorker(ZeroInterstitialEligibilityManager.a(injectorLike));
    }

    @Inject
    public ZeroInterstitialEligibilityConditionalWorker(ZeroInterstitialEligibilityManager zeroInterstitialEligibilityManager) {
        this.f229a = zeroInterstitialEligibilityManager;
    }

    public final boolean m233a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f229a.c();
        return true;
    }
}
