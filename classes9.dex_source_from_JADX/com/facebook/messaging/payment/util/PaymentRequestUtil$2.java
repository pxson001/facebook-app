package com.facebook.messaging.payment.util;

import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentUserModel;

/* compiled from: f0b773fe05b88f8aa9e08cff99020ce6 */
final class PaymentRequestUtil$2 implements PaymentUser {
    final /* synthetic */ PaymentUserModel f15165a;

    PaymentRequestUtil$2(PaymentUserModel paymentUserModel) {
        this.f15165a = paymentUserModel;
    }

    public final String mo526b() {
        return this.f15165a.m13879c();
    }

    public final String mo527c() {
        return this.f15165a.lE_();
    }

    public final boolean mo528d() {
        return this.f15165a.m13880d();
    }
}
