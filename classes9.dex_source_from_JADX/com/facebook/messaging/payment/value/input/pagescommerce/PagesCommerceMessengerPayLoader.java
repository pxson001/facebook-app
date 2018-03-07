package com.facebook.messaging.payment.value.input.pagescommerce;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.MailingAddressInfo;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentAddressUtil;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17769;
import com.facebook.messaging.payment.value.input.MessengerPayData;
import com.facebook.messaging.payment.value.input.MessengerPayLoader;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: emoji_popup */
public class PagesCommerceMessengerPayLoader implements MessengerPayLoader {
    public final Executor f15800a;
    public final AbstractFbErrorReporter f15801b;
    private final PaymentMethodsInfoCache f15802c;
    public final PaymentProtocolUtil f15803d;
    public C17769 f15804e;
    public MessengerPayData f15805f;
    private ListenableFuture<PaymentMethodsInfo> f15806g;
    public ListenableFuture<ArrayList<MailingAddressInfo>> f15807h;

    /* compiled from: emoji_popup */
    class C18581 implements FutureCallback<PaymentMethodsInfo> {
        final /* synthetic */ PagesCommerceMessengerPayLoader f15798a;

        C18581(PagesCommerceMessengerPayLoader pagesCommerceMessengerPayLoader) {
            this.f15798a = pagesCommerceMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            PaymentMethodsInfo paymentMethodsInfo = (PaymentMethodsInfo) obj;
            if (this.f15798a.f15805f.f15450g == null || !this.f15798a.f15805f.f15450g.isPresent()) {
                this.f15798a.f15805f.m15751a(Optional.fromNullable(Iterables.a(paymentMethodsInfo.d, null)));
            }
            this.f15798a.f15805f.m15742a(paymentMethodsInfo.a);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: emoji_popup */
    public class C18592 implements FutureCallback<ArrayList<MailingAddressInfo>> {
        final /* synthetic */ PagesCommerceMessengerPayLoader f15799a;

        public C18592(PagesCommerceMessengerPayLoader pagesCommerceMessengerPayLoader) {
            this.f15799a = pagesCommerceMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15799a.f15805f.m15752a(PaymentAddressUtil.m15514a((ArrayList) obj));
        }

        public void onFailure(Throwable th) {
            this.f15799a.f15801b.a("PagesCommerceMessengerPayLoader", "Failed to fetch shipping addresses.");
            this.f15799a.f15804e.m15639a();
        }
    }

    @Inject
    public PagesCommerceMessengerPayLoader(Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, PaymentMethodsInfoCache paymentMethodsInfoCache, PaymentProtocolUtil paymentProtocolUtil) {
        this.f15800a = executor;
        this.f15801b = abstractFbErrorReporter;
        this.f15802c = paymentMethodsInfoCache;
        this.f15803d = paymentProtocolUtil;
    }

    public final void mo613a(C17769 c17769) {
        this.f15804e = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15805f = messengerPayData;
        m15992a(bundle);
        if (m15993a(this.f15807h)) {
            this.f15807h = this.f15803d.m14964c();
            Futures.a(this.f15807h, new C18592(this), this.f15800a);
        }
    }

    private void m15992a(Bundle bundle) {
        if (m15993a(this.f15806g)) {
            JSONObject put;
            try {
                put = new JSONObject().put("invoice_id", bundle.getString("invoice_id"));
            } catch (JSONException e) {
                put = null;
            }
            this.f15806g = this.f15802c.m18739b(PaymentItemType.PAGES_COMMERCE, "0", put, null);
            Futures.a(this.f15806g, new C18581(this), this.f15800a);
        }
    }

    public final void mo611a() {
        if (!m15993a(this.f15806g)) {
            this.f15806g.cancel(true);
            this.f15806g = null;
        }
        if (!m15993a(this.f15807h)) {
            this.f15807h.cancel(true);
            this.f15807h = null;
        }
    }

    public static boolean m15993a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}
