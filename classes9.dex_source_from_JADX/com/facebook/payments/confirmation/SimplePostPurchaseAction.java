package com.facebook.payments.confirmation;

import com.google.common.base.Preconditions;

/* compiled from: call_gaps */
public class SimplePostPurchaseAction {
    public final String f18624a;
    public final PostPurchaseActionType f18625b;

    public SimplePostPurchaseAction(String str, PostPurchaseActionType postPurchaseActionType) {
        this.f18624a = str;
        this.f18625b = (PostPurchaseActionType) Preconditions.checkNotNull(postPurchaseActionType);
    }
}
