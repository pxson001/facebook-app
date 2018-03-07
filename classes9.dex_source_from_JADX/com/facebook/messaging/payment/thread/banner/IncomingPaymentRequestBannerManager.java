package com.facebook.messaging.payment.thread.banner;

import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed to find capable camera to turn on video */
public class IncomingPaymentRequestBannerManager {
    public final PaymentRequestCache f15064a;
    public final PaymentProtocolUtil f15065b;
    public final PaymentRequestUtil f15066c;
    public final Provider<Boolean> f15067d;
    public PaymentRequestModel f15068e;

    public static IncomingPaymentRequestBannerManager m15451a(InjectorLike injectorLike) {
        return new IncomingPaymentRequestBannerManager(PaymentRequestCache.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike), PaymentRequestUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4182));
    }

    @Inject
    public IncomingPaymentRequestBannerManager(PaymentRequestCache paymentRequestCache, PaymentProtocolUtil paymentProtocolUtil, PaymentRequestUtil paymentRequestUtil, Provider<Boolean> provider) {
        this.f15064a = paymentRequestCache;
        this.f15065b = paymentProtocolUtil;
        this.f15066c = paymentRequestUtil;
        this.f15067d = provider;
    }

    @Nullable
    public final PaymentRequestModel m15452a() {
        return this.f15068e;
    }
}
