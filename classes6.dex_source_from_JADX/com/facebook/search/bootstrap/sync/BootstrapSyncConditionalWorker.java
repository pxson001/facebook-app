package com.facebook.search.bootstrap.sync;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: ex_tag_index */
public class BootstrapSyncConditionalWorker implements ConditionalWorker {
    private final Lazy<BootstrapEntitiesLoader> f15850a;
    private final Lazy<BootstrapKeywordsLoader> f15851b;

    @Inject
    public BootstrapSyncConditionalWorker(Lazy<BootstrapEntitiesLoader> lazy, Lazy<BootstrapKeywordsLoader> lazy2) {
        this.f15850a = lazy;
        this.f15851b = lazy2;
    }

    public final boolean m23481a(ConditionalWorkerRunner conditionalWorkerRunner) {
        Boolean valueOf;
        Boolean valueOf2 = Boolean.valueOf(false);
        try {
            if (conditionalWorkerRunner.a()) {
                ((BootstrapEntitiesLoader) this.f15850a.get()).m23465a();
                ((BootstrapKeywordsLoader) this.f15851b.get()).m23480a();
                valueOf = Boolean.valueOf(true);
                return valueOf.booleanValue();
            }
        } catch (Exception e) {
        }
        valueOf = valueOf2;
        return valueOf.booleanValue();
    }
}
