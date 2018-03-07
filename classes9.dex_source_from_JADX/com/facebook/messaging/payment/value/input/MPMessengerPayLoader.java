package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17769;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: expirationTimeMs */
public class MPMessengerPayLoader implements MessengerPayLoader {
    public final Executor f15389a;
    public final AbstractFbErrorReporter f15390b;
    private final PaymentCardsFetcher f15391c;
    public final PaymentMethodsInfoCache f15392d;
    public final PaymentPinProtocolUtil f15393e;
    public C17769 f15394f;
    public MessengerPayData f15395g;
    public ListenableFuture<PaymentPin> f15396h;
    private ListenableFuture<ImmutableList<PaymentCard>> f15397i;
    public ListenableFuture<PaymentMethodsInfo> f15398j;

    /* compiled from: expirationTimeMs */
    public class C17951 implements FutureCallback<PaymentPin> {
        final /* synthetic */ MPMessengerPayLoader f15387a;

        public C17951(MPMessengerPayLoader mPMessengerPayLoader) {
            this.f15387a = mPMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15387a.f15395g.m15745a((PaymentPin) obj);
        }

        public void onFailure(Throwable th) {
            this.f15387a.f15390b.a("MPMessengerPayLoader", "Failed to fetch PaymentPin to confirm the sending of money");
            this.f15387a.f15394f.m15639a();
        }
    }

    /* compiled from: expirationTimeMs */
    public class C17962 implements FutureCallback<PaymentMethodsInfo> {
        final /* synthetic */ MPMessengerPayLoader f15388a;

        public C17962(MPMessengerPayLoader mPMessengerPayLoader) {
            this.f15388a = mPMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15388a.f15395g.m15751a(Optional.fromNullable(Iterables.a(((PaymentMethodsInfo) obj).d, null)));
        }

        public void onFailure(Throwable th) {
        }
    }

    public static MPMessengerPayLoader m15712b(InjectorLike injectorLike) {
        return new MPMessengerPayLoader((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentCardsFetcher.m13429a(injectorLike), PaymentMethodsInfoCache.m18732a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike));
    }

    @Inject
    public MPMessengerPayLoader(Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, PaymentCardsFetcher paymentCardsFetcher, PaymentMethodsInfoCache paymentMethodsInfoCache, PaymentPinProtocolUtil paymentPinProtocolUtil) {
        this.f15389a = executor;
        this.f15390b = abstractFbErrorReporter;
        this.f15391c = paymentCardsFetcher;
        this.f15392d = paymentMethodsInfoCache;
        this.f15393e = paymentPinProtocolUtil;
    }

    public final void mo613a(C17769 c17769) {
        this.f15394f = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15395g = messengerPayData;
        if (m15711a(this.f15396h)) {
            this.f15396h = this.f15393e.m14283a();
            Futures.a(this.f15396h, new C17951(this), this.f15389a);
        }
        if (m15711a(this.f15398j)) {
            this.f15398j = this.f15392d.m18738b(PaymentItemType.MESSENGER_COMMERCE, "0");
            Futures.a(this.f15398j, new C17962(this), this.f15389a);
        }
    }

    public final void mo611a() {
        if (!m15711a(this.f15396h)) {
            this.f15396h.cancel(true);
            this.f15396h = null;
        }
        if (!m15711a(this.f15397i)) {
            this.f15397i.cancel(true);
            this.f15397i = null;
        }
        if (!m15711a(this.f15398j)) {
            this.f15398j.cancel(true);
            this.f15398j = null;
        }
    }

    public static boolean m15711a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}
