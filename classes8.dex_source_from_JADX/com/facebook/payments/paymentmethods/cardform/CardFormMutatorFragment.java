package com.facebook.payments.paymentmethods.cardform;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.cardform.CardFormFragment.C01871;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_delete_cancel_button */
public class CardFormMutatorFragment extends FbFragment {
    private static final Class<?> f1834e = CardFormMutatorFragment.class;
    @Inject
    public AnalyticsLogger f1835a;
    public ListenableFuture al;
    public ListenableFuture am;
    @Inject
    @ForUiThread
    public Executor f1836b;
    @Inject
    public AbstractFbErrorReporter f1837c;
    @Inject
    public SimpleCardFormManager f1838d;
    public CardFormParams f1839f;
    public C01871 f1840g;
    public SimpleCardFormMutator f1841h;
    public SimplePaymentsComponentCallback f1842i;

    /* compiled from: tap_delete_cancel_button */
    public class C02031 extends ResultFutureCallback {
        final /* synthetic */ CardFormMutatorFragment f1831a;

        public C02031(CardFormMutatorFragment cardFormMutatorFragment) {
            this.f1831a = cardFormMutatorFragment;
        }

        protected final void m2021a(ServiceException serviceException) {
            this.f1831a.f1840g.m1978b();
        }

        protected final void m2022a(Object obj) {
            this.f1831a.f1840g.m1978b();
        }
    }

    public static void m2027a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CardFormMutatorFragment cardFormMutatorFragment = (CardFormMutatorFragment) obj;
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        SimpleCardFormManager a2 = SimpleCardFormManager.m2071a(injectorLike);
        cardFormMutatorFragment.f1835a = a;
        cardFormMutatorFragment.f1836b = executor;
        cardFormMutatorFragment.f1837c = abstractFbErrorReporter;
        cardFormMutatorFragment.f1838d = a2;
    }

    public final void m2032c(@Nullable Bundle bundle) {
        Object obj;
        super.c(bundle);
        Class cls = CardFormMutatorFragment.class;
        m2027a(this, getContext());
        this.f1839f = (CardFormParams) this.s.getParcelable("card_form_params");
        SimpleCardFormManager simpleCardFormManager = this.f1838d;
        CardFormStyle cardFormStyle = this.f1839f.mo78a().f1772a;
        if (simpleCardFormManager.f1874a.containsKey(cardFormStyle)) {
            obj = ((CardFormStyleAssociation) simpleCardFormManager.f1874a.get(cardFormStyle)).f1848f.get();
        } else {
            obj = ((CardFormStyleAssociation) simpleCardFormManager.f1874a.get(CardFormStyle.SIMPLE)).f1848f.get();
        }
        this.f1841h = (SimpleCardFormMutator) obj;
        this.f1841h.mo85a(this.f1842i);
    }

    public final void m2030I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -274537242);
        super.I();
        if (this.al != null) {
            this.al.cancel(true);
            this.al = null;
        }
        if (this.am != null) {
            this.am.cancel(true);
            this.am = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 397204726, a);
    }

    public final void m2031a(final CardFormInput cardFormInput) {
        if (!m2028a(this.al)) {
            this.f1840g.m1977a();
            this.al = this.f1841h.m2081a(this.f1839f, cardFormInput);
            Futures.a(this.al, new ResultFutureCallback(this) {
                final /* synthetic */ CardFormMutatorFragment f1833b;

                protected final void m2023a(ServiceException serviceException) {
                    CardFormMutatorFragment.m2025a(this.f1833b, serviceException, this.f1833b.f1839f, cardFormInput);
                }

                protected final void m2024a(Object obj) {
                    CardFormMutatorFragment.m2026a(this.f1833b, this.f1833b.f1839f, cardFormInput);
                }
            }, this.f1836b);
            this.f1835a.a(CardFormAnalyticsEvent.m1970c(this.f1839f.mo78a().f1773b.f1769b, m2029b(this.f1839f).m2054b(this.f1839f)));
        }
    }

    public static void m2026a(CardFormMutatorFragment cardFormMutatorFragment, CardFormParams cardFormParams, CardFormInput cardFormInput) {
        cardFormMutatorFragment.f1835a.a(CardFormAnalyticsEvent.m1971d(cardFormParams.mo78a().f1773b.f1769b, cardFormMutatorFragment.m2029b(cardFormParams).m2055c(cardFormParams)).m1968a(cardFormInput.m2002a()).f1767a);
    }

    public static void m2025a(CardFormMutatorFragment cardFormMutatorFragment, ServiceException serviceException, CardFormParams cardFormParams, CardFormInput cardFormInput) {
        cardFormMutatorFragment.f1840g.m1978b();
        BLog.b(f1834e, "Card failed to update card", serviceException);
        cardFormMutatorFragment.f1837c.a(cardFormParams.mo78a().f1773b.f1769b, "Attempted to submit card form, but received a response with an error", serviceException);
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            cardFormMutatorFragment.f1835a.a(CardFormAnalyticsEvent.m1971d(cardFormParams.mo78a().f1773b.f1769b, cardFormMutatorFragment.m2029b(cardFormParams).m2056d(cardFormParams)).m1968a(cardFormInput.m2002a()).m1969b(serviceException.getMessage()).f1767a);
            return;
        }
        cardFormMutatorFragment.f1835a.a(CardFormAnalyticsEvent.m1971d(cardFormParams.mo78a().f1773b.f1769b, cardFormMutatorFragment.m2029b(cardFormParams).m2056d(cardFormParams)).m1968a(cardFormInput.m2002a()).m1969b(ApiErrorResult.a(((ApiErrorResult) serviceException.result.h()).c())).f1767a);
    }

    private SimpleCardFormAnalyticsEventSelector m2029b(CardFormParams cardFormParams) {
        return this.f1838d.m2074b(cardFormParams.mo78a().f1772a);
    }

    public static boolean m2028a(Future future) {
        return (future == null || future.isDone()) ? false : true;
    }
}
