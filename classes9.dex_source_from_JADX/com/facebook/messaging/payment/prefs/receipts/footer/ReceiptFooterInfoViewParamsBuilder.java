package com.facebook.messaging.payment.prefs.receipts.footer;

import android.support.v4.util.Pair;
import com.google.common.collect.ImmutableList;

/* compiled from: getmoments */
public class ReceiptFooterInfoViewParamsBuilder {
    public String f14093a;
    public ImmutableList<Pair<Integer, String>> f14094b;

    public final String m14571a() {
        return this.f14093a;
    }

    public final ReceiptFooterInfoViewParamsBuilder m14570a(String str) {
        this.f14093a = str;
        return this;
    }

    public final ImmutableList<Pair<Integer, String>> m14572b() {
        return this.f14094b;
    }

    public final ReceiptFooterInfoViewParamsBuilder m14569a(ImmutableList<Pair<Integer, String>> immutableList) {
        this.f14094b = immutableList;
        return this;
    }

    public final ReceiptFooterInfoViewParams m14573c() {
        return new ReceiptFooterInfoViewParams(this);
    }
}
