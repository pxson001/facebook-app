package com.facebook.fbservice.service;

/* compiled from: restart */
public class BlueServiceChainedProgressCallback implements BlueServiceProgressCallback {
    private final BlueServiceProgressCallback f3049a;
    private final ChainedProgressCallback f3050b;

    /* compiled from: restart */
    public abstract class ChainedProgressCallback implements BlueServiceProgressCallback {
        public abstract OperationResult mo1093b(OperationResult operationResult);

        public final void m4201a(OperationResult operationResult) {
            throw new UnsupportedOperationException();
        }
    }

    public BlueServiceChainedProgressCallback(BlueServiceProgressCallback blueServiceProgressCallback, ChainedProgressCallback chainedProgressCallback) {
        this.f3049a = blueServiceProgressCallback;
        this.f3050b = chainedProgressCallback;
    }

    public final void m4203a(OperationResult operationResult) {
        this.f3049a.a(this.f3050b.mo1093b(operationResult));
    }
}
