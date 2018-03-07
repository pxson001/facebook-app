package com.facebook.search.suggestions.nullstate;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import javax.inject.Inject;

/* compiled from: webview */
public class NullStateSyncConditionalWorker implements ConditionalWorker {
    private final SearchNullStateListSupplier f194a;
    private final AbstractFbErrorReporter f195b;

    @Inject
    public NullStateSyncConditionalWorker(SearchNullStateListSupplier searchNullStateListSupplier, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f194a = searchNullStateListSupplier;
        this.f195b = abstractFbErrorReporter;
    }

    public final boolean m327a(ConditionalWorkerRunner conditionalWorkerRunner) {
        try {
            if (conditionalWorkerRunner.a()) {
                this.f194a.a(null, RefreshPolicy.MEMORY);
                return true;
            }
        } catch (Throwable e) {
            this.f195b.a("NullStateSync", e);
        }
        return false;
    }
}
