package com.facebook.messaging.payment.thread;

import android.support.annotation.ColorRes;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.model.MessengerPayEntityType;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: failed_fetch_thread_list_communication */
public class PaymentViewParamsBuilder {
    public MessengerPayEntityType f15027a;
    public Message f15028b;
    public ThreadPaymentTransactionData f15029c;
    public PaymentRequestModel f15030d;
    public String f15031e;
    public Optional<String> f15032f = Absent.INSTANCE;
    @ColorRes
    public int f15033g;

    public final MessengerPayEntityType m15396a() {
        return this.f15027a;
    }

    public final PaymentViewParamsBuilder m15399a(MessengerPayEntityType messengerPayEntityType) {
        this.f15027a = messengerPayEntityType;
        return this;
    }

    public final Message m15404b() {
        return this.f15028b;
    }

    public final PaymentViewParamsBuilder m15398a(Message message) {
        this.f15028b = message;
        return this;
    }

    public final ThreadPaymentTransactionData m15405c() {
        return this.f15029c;
    }

    public final PaymentViewParamsBuilder m15401a(ThreadPaymentTransactionData threadPaymentTransactionData) {
        this.f15029c = threadPaymentTransactionData;
        return this;
    }

    public final PaymentViewParamsBuilder m15400a(PaymentRequestModel paymentRequestModel) {
        this.f15030d = paymentRequestModel;
        return this;
    }

    public final String m15406e() {
        return this.f15031e;
    }

    public final PaymentViewParamsBuilder m15403a(String str) {
        this.f15031e = str;
        return this;
    }

    public final Optional<String> m15407f() {
        return this.f15032f;
    }

    public final PaymentViewParamsBuilder m15402a(Optional<String> optional) {
        this.f15032f = optional;
        return this;
    }

    @ColorRes
    public final int m15408g() {
        return this.f15033g;
    }

    public final PaymentViewParamsBuilder m15397a(@ColorRes int i) {
        this.f15033g = i;
        return this;
    }

    public final PaymentViewParams m15409h() {
        return new PaymentViewParams(this);
    }
}
