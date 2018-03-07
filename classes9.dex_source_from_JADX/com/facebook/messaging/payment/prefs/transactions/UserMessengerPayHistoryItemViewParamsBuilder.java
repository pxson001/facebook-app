package com.facebook.messaging.payment.prefs.transactions;

import com.facebook.messaging.payment.model.PaymentUser;

/* compiled from: friend_watcher_count */
public class UserMessengerPayHistoryItemViewParamsBuilder {
    public PaymentUser f14420a;
    public MessengerPayHistoryItemViewCommonParams f14421b;

    public final MessengerPayHistoryItemViewCommonParams m14812a() {
        return this.f14421b;
    }

    public final UserMessengerPayHistoryItemViewParamsBuilder m14814a(MessengerPayHistoryItemViewCommonParams messengerPayHistoryItemViewCommonParams) {
        this.f14421b = messengerPayHistoryItemViewCommonParams;
        return this;
    }

    public final PaymentUser m14815b() {
        return this.f14420a;
    }

    public final UserMessengerPayHistoryItemViewParamsBuilder m14813a(PaymentUser paymentUser) {
        this.f14420a = paymentUser;
        return this;
    }

    public final UserMessengerPayHistoryItemViewParams m14816c() {
        return new UserMessengerPayHistoryItemViewParams(this);
    }
}
