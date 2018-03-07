package com.facebook.gk.internal;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import javax.inject.Inject;

/* compiled from: timestamp_in_video */
public class GkSessionlessConditionalWorker implements ConditionalWorker {
    private final GkSessionlessFetcher f992a;

    @Inject
    public GkSessionlessConditionalWorker(GkSessionlessFetcher gkSessionlessFetcher) {
        this.f992a = gkSessionlessFetcher;
    }

    public final boolean mo83a(ConditionalWorkerRunner conditionalWorkerRunner) {
        return this.f992a.m1314a();
    }
}
