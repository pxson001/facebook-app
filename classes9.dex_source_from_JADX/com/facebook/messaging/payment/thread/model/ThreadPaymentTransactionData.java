package com.facebook.messaging.payment.thread.model;

import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: failed all friends */
public class ThreadPaymentTransactionData {
    @Nullable
    public final Optional<PaymentCard> f15113a;
    public final Optional<ImmutableList<PaymentCard>> f15114b;
    @Nullable
    public final PaymentTransaction f15115c;

    public ThreadPaymentTransactionData(@Nullable Optional<PaymentCard> optional, Optional<ImmutableList<PaymentCard>> optional2, @Nullable PaymentTransaction paymentTransaction) {
        this.f15113a = optional;
        this.f15114b = optional2;
        this.f15115c = paymentTransaction;
    }
}
