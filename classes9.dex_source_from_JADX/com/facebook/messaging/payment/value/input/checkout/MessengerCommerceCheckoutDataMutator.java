package com.facebook.messaging.payment.value.input.checkout;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.payments.checkout.SimpleCheckoutDataMutator;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.model.SimpleCheckoutData;
import com.facebook.payments.checkout.model.SimpleCheckoutDataBuilder;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingOption;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: end_time_millis */
public class MessengerCommerceCheckoutDataMutator extends SimpleCheckoutDataMutator {
    public static final String f15753c = MessengerCommerceCheckoutDataMutator.class.getSimpleName();
    private final PaymentProtocolUtil f15754d;
    private final Executor f15755e;
    public final AbstractFbErrorReporter f15756f;
    private ListenableFuture<PaymentPlatformContext> f15757g;

    @Inject
    public MessengerCommerceCheckoutDataMutator(PaymentProtocolUtil paymentProtocolUtil, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15754d = paymentProtocolUtil;
        this.f15755e = executor;
        this.f15756f = abstractFbErrorReporter;
    }

    public final void mo641a(SimpleCheckoutData simpleCheckoutData, MailingAddress mailingAddress) {
        Object obj;
        Preconditions.checkNotNull(this.f15751a);
        SimpleCheckoutDataBuilder a = SimpleCheckoutData.newBuilder().m18526a((CheckoutData) simpleCheckoutData).m18527a(SimpleCheckoutDataMutator.m15930a(simpleCheckoutData.mo723g(), mailingAddress));
        a.f18508f = Optional.of(mailingAddress);
        a = a;
        a.f18511i = null;
        a = a;
        a.f18510h = null;
        final SimpleCheckoutData n = a.m18528n();
        this.f15751a.m18469a(n);
        ListenableFuture listenableFuture = this.f15757g;
        if (listenableFuture == null || listenableFuture.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f15757g.cancel(true);
        }
        final PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) simpleCheckoutData.mo726j();
        this.f15757g = this.f15754d.m14959a(paymentPlatformContextModel.m13756d(), mailingAddress.mo760a());
        Futures.a(this.f15757g, new ResultFutureCallback<PaymentPlatformContext>(this) {
            final /* synthetic */ MessengerCommerceCheckoutDataMutator f15750c;

            protected final void m15928a(Object obj) {
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) obj;
                Preconditions.checkArgument(paymentPlatformContextModel.m13756d().equals(paymentPlatformContextModel.m13756d()));
                MessengerCommerceCheckoutDataMutator.m15944a(this.f15750c, n, paymentPlatformContextModel);
            }

            protected final void m15927a(ServiceException serviceException) {
                this.f15750c.f15756f.a(MessengerCommerceCheckoutDataMutator.f15753c, "Failed to set shipping address.");
            }
        }, this.f15755e);
        Preconditions.checkNotNull(this.f15752b);
        this.f15752b.a(this.f15757g);
    }

    public static void m15944a(MessengerCommerceCheckoutDataMutator messengerCommerceCheckoutDataMutator, CheckoutData checkoutData, PaymentPlatformContextModel paymentPlatformContextModel) {
        ImmutableList a = PaymentShippingOptionUtil.m15977a(paymentPlatformContextModel.m13760l());
        ShippingOption a2 = PaymentShippingOptionUtil.m15976a(paymentPlatformContextModel.m13758j());
        SimpleCheckoutDataBuilder a3 = SimpleCheckoutData.newBuilder().m18526a(checkoutData);
        a3.f18511i = a;
        SimpleCheckoutDataBuilder simpleCheckoutDataBuilder = a3;
        simpleCheckoutDataBuilder.f18510h = Optional.of(a2);
        simpleCheckoutDataBuilder = simpleCheckoutDataBuilder;
        simpleCheckoutDataBuilder.f18512j = (Flattenable) paymentPlatformContextModel;
        messengerCommerceCheckoutDataMutator.f15751a.m18469a(simpleCheckoutDataBuilder.m18528n());
    }
}
