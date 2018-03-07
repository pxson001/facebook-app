package com.facebook.resources.impl.loading;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import javax.inject.Inject;

/* compiled from: PRIMARY_ACTION_BUTTON_GLYPH */
public class LanguagePrefetchConditionalWorker implements ConditionalWorker {
    private final LanguagePrefetcher f12527a;

    @Inject
    public LanguagePrefetchConditionalWorker(LanguagePrefetcher languagePrefetcher) {
        this.f12527a = languagePrefetcher;
    }

    public final boolean m12931a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f12527a.m12940a();
        return true;
    }
}
