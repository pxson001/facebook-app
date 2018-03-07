package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.payments.checkout.CheckoutFragment.C21395;
import com.facebook.payments.checkout.CheckoutParams;
import com.facebook.payments.checkout.SimpleCheckoutDataLoader;
import com.facebook.payments.checkout.model.CheckoutItemPrice;
import com.facebook.payments.checkout.model.SimpleCheckoutItemPrice;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.shipping.protocol.MailingAddressCache;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: engSwapInterval failed */
public class MessengerCommerceCheckoutDataLoader extends SimpleCheckoutDataLoader {
    public final PaymentCurrencyUtil f15745c;
    public final PaymentProtocolUtil f15746d;
    private ListenableFuture<List<Object>> f15747e;

    /* compiled from: engSwapInterval failed */
    class C18481 extends ResultFutureCallback<List<Object>> {
        final /* synthetic */ MessengerCommerceCheckoutDataLoader f15737a;

        C18481(MessengerCommerceCheckoutDataLoader messengerCommerceCheckoutDataLoader) {
            this.f15737a = messengerCommerceCheckoutDataLoader;
        }

        protected final void m15918a(ServiceException serviceException) {
            this.f15737a.f15740b.m18471b();
        }

        protected final void m15919a(Object obj) {
            if (!this.f15737a.mo639a()) {
                this.f15737a.f15740b.m18470a();
            }
        }
    }

    /* compiled from: engSwapInterval failed */
    public class C18492 extends ResultFutureCallback<PaymentPlatformContext> {
        final /* synthetic */ MessengerCommerceCheckoutDataLoader f15738a;

        public C18492(MessengerCommerceCheckoutDataLoader messengerCommerceCheckoutDataLoader) {
            this.f15738a = messengerCommerceCheckoutDataLoader;
        }

        protected final void m15921a(Object obj) {
            CurrencyAmount a;
            PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
            C21395 c21395 = this.f15738a.f15740b;
            Flattenable flattenable = (Flattenable) paymentPlatformContextModel;
            Preconditions.checkNotNull(flattenable);
            c21395.f18469a.am.m15931a(c21395.f18469a.al, flattenable);
            SimpleCheckoutDataLoader simpleCheckoutDataLoader = this.f15738a;
            Preconditions.checkNotNull(paymentPlatformContextModel.m13757g());
            PaymentShippingOptionModel j = paymentPlatformContextModel.m13758j();
            PaymentPlatformItemModel g = paymentPlatformContextModel.m13757g();
            if (j == null) {
                a = simpleCheckoutDataLoader.f15745c.m13197a(g.lu_().m13691a(), g.lu_().m13695b());
            } else {
                a = simpleCheckoutDataLoader.f15745c.m13197a(j.m13828g(), j.m13823a());
            }
            CheckoutItemPrice simpleCheckoutItemPrice = new SimpleCheckoutItemPrice(a);
            C21395 c213952 = simpleCheckoutDataLoader.f15740b;
            Preconditions.checkNotNull(simpleCheckoutItemPrice);
            c213952.f18469a.am.m15932a(c213952.f18469a.al, simpleCheckoutItemPrice);
            simpleCheckoutDataLoader = this.f15738a;
            List l = paymentPlatformContextModel.m13760l();
            C21395 c213953 = simpleCheckoutDataLoader.f15740b;
            ImmutableList a2 = PaymentShippingOptionUtil.m15977a(l);
            Preconditions.checkNotNull(a2);
            c213953.f18469a.am.m15938a(c213953.f18469a.al, a2);
        }

        protected final void m15920a(ServiceException serviceException) {
            this.f15738a.f15740b.m18471b();
        }
    }

    public static MessengerCommerceCheckoutDataLoader m15924c(InjectorLike injectorLike) {
        return new MessengerCommerceCheckoutDataLoader((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 9225), IdBasedProvider.a(injectorLike, 9170), PaymentCurrencyUtil.m13192a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike));
    }

    @Inject
    public MessengerCommerceCheckoutDataLoader(Executor executor, Provider<MailingAddressCache> provider, Provider<PaymentMethodsInfoCache> provider2, PaymentCurrencyUtil paymentCurrencyUtil, PaymentPinProtocolUtil paymentPinProtocolUtil, PaymentProtocolUtil paymentProtocolUtil) {
        super(executor, paymentPinProtocolUtil, provider, provider2);
        this.f15745c = paymentCurrencyUtil;
        this.f15746d = paymentProtocolUtil;
    }

    public final ListenableFuture mo638a(CheckoutParams checkoutParams) {
        if (this.f15747e != null && !this.f15747e.isDone()) {
            return this.f15747e;
        }
        Preconditions.checkArgument(checkoutParams instanceof MessengerCommerceCheckoutParams);
        MessengerCommerceCheckoutParams messengerCommerceCheckoutParams = (MessengerCommerceCheckoutParams) checkoutParams;
        ListenableFuture a = super.mo638a(checkoutParams);
        ListenableFuture d = this.f15746d.m14966d(messengerCommerceCheckoutParams.f15759b);
        Futures.a(d, new C18492(this), this.f15739a);
        this.f15747e = Futures.b(ImmutableList.of(a, d));
        Futures.a(this.f15747e, new C18481(this), this.f15739a);
        return this.f15747e;
    }

    public final boolean mo639a() {
        return super.mo639a() || !(this.f15747e == null || this.f15747e.isDone());
    }
}
