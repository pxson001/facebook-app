package com.facebook.zero.service;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.token.AbstractZeroTokenManager;
import javax.inject.Inject;

/* compiled from: welcome_header_photo */
public class ZeroTokenConditionalWorker implements ConditionalWorker {
    private final AbstractZeroTokenManager f232a;

    public static ZeroTokenConditionalWorker m234b(InjectorLike injectorLike) {
        return new ZeroTokenConditionalWorker((AbstractZeroTokenManager) FbZeroTokenManager.b(injectorLike));
    }

    @Inject
    public ZeroTokenConditionalWorker(AbstractZeroTokenManager abstractZeroTokenManager) {
        this.f232a = abstractZeroTokenManager;
    }

    public final boolean m235a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f232a.h();
        return true;
    }
}
