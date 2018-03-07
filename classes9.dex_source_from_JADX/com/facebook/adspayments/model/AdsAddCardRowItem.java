package com.facebook.adspayments.model;

import android.content.Intent;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: UY */
public class AdsAddCardRowItem extends AddCardRowItem {
    public final ImmutableSet<FbPaymentCardType> f23679c;

    public AdsAddCardRowItem(Intent intent, int i, ImmutableSet<FbPaymentCardType> immutableSet) {
        super(intent, i);
        this.f23679c = immutableSet;
    }
}
