package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.MailingAddressInfo;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentAddressUtil;
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
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: external_reference_id */
public class MCMessengerPayLoader implements MessengerPayLoader {
    public final Executor f15326a;
    public final AbstractFbErrorReporter f15327b;
    private final PaymentCardsFetcher f15328c;
    public final PaymentPinProtocolUtil f15329d;
    public final PaymentMethodsInfoCache f15330e;
    public final PaymentProtocolUtil f15331f;
    public C17769 f15332g;
    public MessengerPayData f15333h;
    public ListenableFuture<PaymentPin> f15334i;
    private ListenableFuture<ImmutableList<PaymentCard>> f15335j;
    public ListenableFuture<PaymentMethodsInfo> f15336k;
    public ListenableFuture<ArrayList<MailingAddressInfo>> f15337l;

    /* compiled from: external_reference_id */
    public class C17841 implements FutureCallback<PaymentPin> {
        final /* synthetic */ MCMessengerPayLoader f15323a;

        public C17841(MCMessengerPayLoader mCMessengerPayLoader) {
            this.f15323a = mCMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15323a.f15333h.m15745a((PaymentPin) obj);
        }

        public void onFailure(Throwable th) {
            this.f15323a.f15327b.a("MCMessengerPayLoader", "Failed to fetch PaymentPin to confirm the sending of money");
            this.f15323a.f15332g.m15639a();
        }
    }

    /* compiled from: external_reference_id */
    public class C17852 implements FutureCallback<PaymentMethodsInfo> {
        final /* synthetic */ MCMessengerPayLoader f15324a;

        public C17852(MCMessengerPayLoader mCMessengerPayLoader) {
            this.f15324a = mCMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            PaymentMethodsInfo paymentMethodsInfo = (PaymentMethodsInfo) obj;
            if (this.f15324a.f15333h.f15450g == null || !this.f15324a.f15333h.f15450g.isPresent()) {
                this.f15324a.f15333h.m15751a(Optional.fromNullable(Iterables.a(paymentMethodsInfo.d, null)));
            }
            this.f15324a.f15333h.m15742a(paymentMethodsInfo.a);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: external_reference_id */
    public class C17863 implements FutureCallback<ArrayList<MailingAddressInfo>> {
        final /* synthetic */ MCMessengerPayLoader f15325a;

        public C17863(MCMessengerPayLoader mCMessengerPayLoader) {
            this.f15325a = mCMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15325a.f15333h.m15752a(PaymentAddressUtil.m15514a((ArrayList) obj));
        }

        public void onFailure(Throwable th) {
            this.f15325a.f15327b.a("MCMessengerPayLoader", "Failed to fetch shipping addresses.");
            this.f15325a.f15332g.m15639a();
        }
    }

    @Inject
    public MCMessengerPayLoader(Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, PaymentCardsFetcher paymentCardsFetcher, PaymentPinProtocolUtil paymentPinProtocolUtil, PaymentMethodsInfoCache paymentMethodsInfoCache, PaymentProtocolUtil paymentProtocolUtil) {
        this.f15326a = executor;
        this.f15327b = abstractFbErrorReporter;
        this.f15328c = paymentCardsFetcher;
        this.f15329d = paymentPinProtocolUtil;
        this.f15330e = paymentMethodsInfoCache;
        this.f15331f = paymentProtocolUtil;
    }

    public final void mo613a(C17769 c17769) {
        this.f15332g = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15333h = messengerPayData;
        if (m15679a(this.f15334i)) {
            this.f15334i = this.f15329d.m14283a();
            Futures.a(this.f15334i, new C17841(this), this.f15326a);
        }
        if (m15679a(this.f15336k)) {
            this.f15336k = this.f15330e.m18738b(PaymentItemType.MESSENGER_COMMERCE, "0");
            Futures.a(this.f15336k, new C17852(this), this.f15326a);
        }
        if (m15679a(this.f15337l)) {
            this.f15337l = this.f15331f.m14964c();
            Futures.a(this.f15337l, new C17863(this), this.f15326a);
        }
    }

    public final void mo611a() {
        if (!m15679a(this.f15334i)) {
            this.f15334i.cancel(true);
            this.f15334i = null;
        }
        if (!m15679a(this.f15335j)) {
            this.f15335j.cancel(true);
            this.f15335j = null;
        }
        if (!m15679a(this.f15336k)) {
            this.f15336k.cancel(true);
            this.f15336k = null;
        }
        if (!m15679a(this.f15337l)) {
            this.f15337l.cancel(true);
            this.f15337l = null;
        }
    }

    public static boolean m15679a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}
