package com.facebook.messaging.payment.prefs.transactions;

/* compiled from: friends/center.* */
public class ProductMessengerPayHistoryItemViewParamsBuilder {
    public String f14411a;
    public int f14412b;
    public MessengerPayHistoryItemViewCommonParams f14413c;

    public final String m14796a() {
        return this.f14411a;
    }

    public final ProductMessengerPayHistoryItemViewParamsBuilder m14795a(String str) {
        this.f14411a = str;
        return this;
    }

    public final MessengerPayHistoryItemViewCommonParams m14797b() {
        return this.f14413c;
    }

    public final ProductMessengerPayHistoryItemViewParamsBuilder m14794a(MessengerPayHistoryItemViewCommonParams messengerPayHistoryItemViewCommonParams) {
        this.f14413c = messengerPayHistoryItemViewCommonParams;
        return this;
    }

    public final int m14798c() {
        return this.f14412b;
    }

    public final ProductMessengerPayHistoryItemViewParamsBuilder m14793a(int i) {
        this.f14412b = i;
        return this;
    }

    public final ProductMessengerPayHistoryItemViewParams m14799d() {
        return new ProductMessengerPayHistoryItemViewParams(this);
    }
}
