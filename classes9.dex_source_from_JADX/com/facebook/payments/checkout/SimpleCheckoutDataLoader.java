package com.facebook.payments.checkout;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.payments.checkout.CheckoutFragment.C21395;
import com.facebook.payments.model.PaymentsPin;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.protocol.MailingAddressCache;
import com.facebook.payments.shipping.protocol.MailingAddressCache.C22462;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: end_to_end_prerendering */
public class SimpleCheckoutDataLoader {
    public final Executor f15739a;
    public C21395 f15740b;
    public final PaymentPinProtocolUtil f15741c;
    public final Provider<MailingAddressCache> f15742d;
    public final Provider<PaymentMethodsInfoCache> f15743e;
    private ListenableFuture<List<Object>> f15744f;

    /* compiled from: end_to_end_prerendering */
    class C21411 extends ResultFutureCallback<List<Object>> {
        final /* synthetic */ SimpleCheckoutDataLoader f18482a;

        C21411(SimpleCheckoutDataLoader simpleCheckoutDataLoader) {
            this.f18482a = simpleCheckoutDataLoader;
        }

        protected final void m18481a(ServiceException serviceException) {
            this.f18482a.f15740b.m18471b();
        }

        protected final void m18482a(Object obj) {
            if (!this.f18482a.mo639a()) {
                this.f18482a.f15740b.m18470a();
            }
        }
    }

    /* compiled from: end_to_end_prerendering */
    public class C21422 extends ResultFutureCallback<PaymentMethodsInfo> {
        final /* synthetic */ SimpleCheckoutDataLoader f18483a;

        public C21422(SimpleCheckoutDataLoader simpleCheckoutDataLoader) {
            this.f18483a = simpleCheckoutDataLoader;
        }

        protected final void m18484a(Object obj) {
            PaymentMethodsInfo paymentMethodsInfo = (PaymentMethodsInfo) obj;
            C21395 c21395 = this.f18483a.f15740b;
            ImmutableList immutableList = paymentMethodsInfo.d;
            Preconditions.checkNotNull(immutableList);
            c21395.f18469a.am.m15943c(c21395.f18469a.al, immutableList);
        }

        protected final void m18483a(ServiceException serviceException) {
            this.f18483a.f15740b.m18471b();
        }
    }

    /* compiled from: end_to_end_prerendering */
    public class C21433 extends ResultFutureCallback<ImmutableList<MailingAddress>> {
        final /* synthetic */ SimpleCheckoutDataLoader f18484a;

        public C21433(SimpleCheckoutDataLoader simpleCheckoutDataLoader) {
            this.f18484a = simpleCheckoutDataLoader;
        }

        protected final void m18486a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            C21395 c21395 = this.f18484a.f15740b;
            Preconditions.checkNotNull(immutableList);
            c21395.f18469a.am.m15942b(c21395.f18469a.al, immutableList);
        }

        protected final void m18485a(ServiceException serviceException) {
            this.f18484a.f15740b.m18471b();
        }
    }

    /* compiled from: end_to_end_prerendering */
    public class C21444 extends ResultFutureCallback<PaymentPin> {
        final /* synthetic */ SimpleCheckoutDataLoader f18485a;

        public C21444(SimpleCheckoutDataLoader simpleCheckoutDataLoader) {
            this.f18485a = simpleCheckoutDataLoader;
        }

        protected final void m18488a(Object obj) {
            PaymentPin paymentPin = (PaymentPin) obj;
            C21395 c21395 = this.f18485a.f15740b;
            PaymentsPin b = paymentPin.m14262b();
            Preconditions.checkNotNull(b);
            c21395.f18469a.am.m15934a(c21395.f18469a.al, b);
        }

        protected final void m18487a(ServiceException serviceException) {
            this.f18485a.f15740b.m18471b();
        }
    }

    @Inject
    public SimpleCheckoutDataLoader(Executor executor, PaymentPinProtocolUtil paymentPinProtocolUtil, Provider<MailingAddressCache> provider, Provider<PaymentMethodsInfoCache> provider2) {
        this.f15739a = executor;
        this.f15741c = paymentPinProtocolUtil;
        this.f15742d = provider;
        this.f15743e = provider2;
    }

    public ListenableFuture mo638a(CheckoutParams checkoutParams) {
        if (this.f15744f != null && !this.f15744f.isDone()) {
            return this.f15744f;
        }
        ListenableFuture a;
        Preconditions.checkNotNull(this.f15740b);
        ListenableFuture b = ((PaymentMethodsInfoCache) this.f15743e.get()).m18738b(checkoutParams.mo627a().f18460b, "0");
        Futures.a(b, new C21422(this), this.f15739a);
        ListenableFuture listenableFuture = b;
        MailingAddressCache mailingAddressCache = (MailingAddressCache) this.f15742d.get();
        mailingAddressCache.b(((User) mailingAddressCache.f19053d.get()).a);
        String str = ((User) mailingAddressCache.f19053d.get()).a;
        ImmutableList immutableList = (ImmutableList) mailingAddressCache.a(str);
        if (immutableList != null) {
            a = Futures.a(immutableList);
        } else {
            a = mailingAddressCache.f19052c.a(new C22462(mailingAddressCache, str));
        }
        b = a;
        Futures.a(b, new C21433(this), this.f15739a);
        ListenableFuture listenableFuture2 = b;
        b = this.f15741c.m14283a();
        Futures.a(b, new C21444(this), this.f15739a);
        this.f15744f = Futures.b(ImmutableList.of(listenableFuture, listenableFuture2, b));
        Futures.a(this.f15744f, new C21411(this), this.f15739a);
        return this.f15744f;
    }

    public boolean mo639a() {
        return (this.f15744f == null || this.f15744f.isDone()) ? false : true;
    }
}
