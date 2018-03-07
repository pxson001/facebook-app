package com.facebook.messaging.payment.thread;

import android.support.annotation.ColorRes;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: failed_fetch_threads */
public class PaymentViewParams {
    public final MessengerPayEntityType f15020a;
    public final Message f15021b;
    public final ThreadPaymentTransactionData f15022c;
    public final PaymentRequestModel f15023d;
    public final String f15024e;
    public final Optional<String> f15025f;
    @ColorRes
    public final int f15026g;

    public PaymentViewParams(PaymentViewParamsBuilder paymentViewParamsBuilder) {
        this.f15021b = paymentViewParamsBuilder.f15028b;
        this.f15022c = paymentViewParamsBuilder.f15029c;
        this.f15023d = paymentViewParamsBuilder.f15030d;
        this.f15024e = paymentViewParamsBuilder.f15031e;
        this.f15025f = paymentViewParamsBuilder.f15032f;
        this.f15020a = paymentViewParamsBuilder.f15027a;
        this.f15026g = paymentViewParamsBuilder.f15033g;
    }

    public static PaymentViewParamsBuilder newBuilder() {
        return new PaymentViewParamsBuilder();
    }
}
