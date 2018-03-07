package com.facebook.messaging.payment.prefs.receipts.footer;

import android.support.v4.util.Pair;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: giftwrap/ */
public class ReceiptFooterInfoViewParams {
    public final String f14091a;
    public final ImmutableList<Pair<Integer, String>> f14092b;

    public ReceiptFooterInfoViewParams(ReceiptFooterInfoViewParamsBuilder receiptFooterInfoViewParamsBuilder) {
        boolean z;
        if (receiptFooterInfoViewParamsBuilder.f14094b.size() <= 2) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f14091a = receiptFooterInfoViewParamsBuilder.f14093a;
        this.f14092b = receiptFooterInfoViewParamsBuilder.f14094b;
    }

    public static ReceiptFooterInfoViewParamsBuilder newBuilder() {
        return new ReceiptFooterInfoViewParamsBuilder();
    }
}
