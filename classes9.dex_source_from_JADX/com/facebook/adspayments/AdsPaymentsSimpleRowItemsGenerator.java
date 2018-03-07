package com.facebook.adspayments;

import android.content.Context;
import android.content.Intent;
import com.facebook.adspayments.model.AdsAddCardRowItem;
import com.facebook.payments.paymentmethods.model.NewCreditCardOption;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.paymentmethods.picker.model.CountrySelectorRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.picker.model.RowItem;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: Unable to process participants in Canonical Thread for  */
public class AdsPaymentsSimpleRowItemsGenerator extends PaymentMethodsRowItemsGenerator {
    @Inject
    public AdsPaymentsSimpleRowItemsGenerator(Context context, SimplePickerScreenManager simplePickerScreenManager) {
        super(context, simplePickerScreenManager);
    }

    protected final AddCardRowItem mo1083a(Intent intent, NewCreditCardOption newCreditCardOption) {
        return new AdsAddCardRowItem(intent, 1, newCreditCardOption.c);
    }

    protected final void mo1084a(Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData) {
        builder.c(new CountrySelectorRowItem(paymentMethodsPickerScreenData.f18845b.mo743a(), paymentMethodsPickerScreenData.f18844a.a, false));
    }
}
