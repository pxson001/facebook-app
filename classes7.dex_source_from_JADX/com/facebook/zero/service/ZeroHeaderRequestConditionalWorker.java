package com.facebook.zero.service;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: windowPhysicalPixels */
public class ZeroHeaderRequestConditionalWorker implements ConditionalWorker {
    private final ZeroHeaderRequestManager f225a;

    public static ZeroHeaderRequestConditionalWorker m229b(InjectorLike injectorLike) {
        return new ZeroHeaderRequestConditionalWorker(ZeroHeaderRequestManager.a(injectorLike));
    }

    @Inject
    public ZeroHeaderRequestConditionalWorker(ZeroHeaderRequestManager zeroHeaderRequestManager) {
        this.f225a = zeroHeaderRequestManager;
    }

    public final boolean m230a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f225a.a(false);
        return true;
    }
}
