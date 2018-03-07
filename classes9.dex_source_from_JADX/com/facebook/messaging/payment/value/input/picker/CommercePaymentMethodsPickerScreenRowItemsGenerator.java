package com.facebook.messaging.payment.value.input.picker;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.messaging.payment.service.model.cards.NewManualTransferOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.picker.model.RowItem;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: eglGetDisplay failed  */
public class CommercePaymentMethodsPickerScreenRowItemsGenerator extends PaymentMethodsRowItemsGenerator {
    private final Resources f15836a;

    /* compiled from: eglGetDisplay failed  */
    /* synthetic */ class C18641 {
        static final /* synthetic */ int[] f15833a = new int[NewPaymentOptionType.values().length];

        static {
            try {
                f15833a[NewPaymentOptionType.NEW_NET_BANKING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f15833a[NewPaymentOptionType.NEW_PAY_OVER_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f15833a[NewPaymentOptionType.NEW_MANUAL_TRANSFER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public CommercePaymentMethodsPickerScreenRowItemsGenerator(Resources resources, Context context, SimplePickerScreenManager simplePickerScreenManager) {
        super(context, simplePickerScreenManager);
        this.f15836a = resources;
    }

    protected final void mo653a(NewPaymentOption newPaymentOption, Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData, PickerScreenParams pickerScreenParams) {
        switch (C18641.f15833a[newPaymentOption.a().ordinal()]) {
            case 1:
                builder.c(new CommerceSimpleAddPaymentMethodRowItem(this.f15836a.getString(2131238340), newPaymentOption, 201));
                return;
            case 2:
                builder.c(new CommerceSimpleAddPaymentMethodRowItem(this.f15836a.getString(2131238338), newPaymentOption, 201));
                return;
            case 3:
                builder.c(new CommerceSimpleAddPaymentMethodRowItem(((NewManualTransferOption) newPaymentOption).f14646a, newPaymentOption, 201));
                return;
            default:
                super.mo653a(newPaymentOption, builder, paymentMethodsPickerScreenData, pickerScreenParams);
                return;
        }
    }
}
