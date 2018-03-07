package com.facebook.composer.minutiae.protocol;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbsFetcher.C01686;
import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;

/* compiled from: timeline_fetch_first_units_classic */
public class MinutiaeConditionalWorker implements ConditionalWorker {
    private final MinutiaeVerbsFetcher f1672a;
    public final AbstractFbErrorReporter f1673b;
    public final ActivityPickerAnalyticsLogger f1674c;

    /* compiled from: timeline_fetch_first_units_classic */
    class C01581 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ MinutiaeConditionalWorker f1671a;

        C01581(MinutiaeConditionalWorker minutiaeConditionalWorker) {
            this.f1671a = minutiaeConditionalWorker;
        }

        protected final void m1675a(Object obj) {
            this.f1671a.f1674c.f1460a.a(new HoneyClientEvent("activity_picker_background_fetch_success"));
        }

        protected final void m1676a(Throwable th) {
            this.f1671a.f1673b.a("minutiae_verb_background_fetch_failed", "Minutiae verbs background fetch failed", th);
            this.f1671a.f1674c.f1460a.a(new HoneyClientEvent("activity_picker_background_fetch_failed"));
        }
    }

    @Inject
    public MinutiaeConditionalWorker(MinutiaeVerbsFetcher minutiaeVerbsFetcher, AbstractFbErrorReporter abstractFbErrorReporter, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger) {
        this.f1672a = minutiaeVerbsFetcher;
        this.f1673b = abstractFbErrorReporter;
        this.f1674c = activityPickerAnalyticsLogger;
    }

    public final boolean m1677a(ConditionalWorkerRunner conditionalWorkerRunner) {
        if (conditionalWorkerRunner.a()) {
            MinutiaeVerbsFetcher minutiaeVerbsFetcher = this.f1672a;
            Futures.a(minutiaeVerbsFetcher.f1717c.m1671a(MinutiaeVerbsFetcher.m1701b(minutiaeVerbsFetcher, false)), new C01686(minutiaeVerbsFetcher, new C01581(this)), minutiaeVerbsFetcher.f1720f);
        }
        return true;
    }
}
