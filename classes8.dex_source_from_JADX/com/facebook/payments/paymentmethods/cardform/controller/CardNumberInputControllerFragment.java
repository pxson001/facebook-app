package com.facebook.payments.paymentmethods.cardform.controller;

import android.os.Bundle;
import com.facebook.inject.FbInjector;
import com.facebook.payments.paymentmethods.cardform.PaymentMethodInputFormattingUtils;
import javax.annotation.Nullable;

/* compiled from: tag_people_to_place_consecutive_num_times_skipped */
public class CardNumberInputControllerFragment extends PaymentInputControllerFragment {
    public final void m2100c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = CardNumberInputControllerFragment.class;
        FbInjector.get(getContext());
    }

    public final int mo86b() {
        return PaymentMethodInputFormattingUtils.m2051b(this.f1886e.getInputText()).length();
    }
}
