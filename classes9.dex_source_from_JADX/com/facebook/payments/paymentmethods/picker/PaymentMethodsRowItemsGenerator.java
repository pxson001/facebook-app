package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.content.Intent;
import com.facebook.payments.paymentmethods.model.NewCreditCardOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.paymentmethods.picker.model.AddPayPalRowItem;
import com.facebook.payments.paymentmethods.picker.model.CountrySelectorRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsSectionType;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.HeaderRowItem;
import com.facebook.payments.picker.model.PickerSecurityRowItem;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: eglCreateWindowSurface failed  */
public class PaymentMethodsRowItemsGenerator implements RowItemsGenerator<PaymentMethodsPickerScreenData> {
    public final Context f15834a;
    private final SimplePickerScreenManager f15835b;

    /* compiled from: eglCreateWindowSurface failed  */
    final class C21941 implements RowItem {
        C21941() {
        }

        public final RowType mo657a() {
            return RowType.SINGLE_ROW_DIVIDER;
        }
    }

    /* compiled from: eglCreateWindowSurface failed  */
    /* synthetic */ class C21952 {
        static final /* synthetic */ int[] f18766b = new int[NewPaymentOptionType.values().length];

        static {
            try {
                f18766b[NewPaymentOptionType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18766b[NewPaymentOptionType.NEW_CREDIT_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18766b[NewPaymentOptionType.NEW_PAYPAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f18765a = new int[PaymentMethodsSectionType.values().length];
            try {
                f18765a[PaymentMethodsSectionType.COUNTRY_SELECTOR.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18765a[PaymentMethodsSectionType.SELECT_PAYMENT_METHOD.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18765a[PaymentMethodsSectionType.SINGLE_ROW_DIVIDER.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18765a[PaymentMethodsSectionType.ADD_PAYMENT_METHOD.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18765a[PaymentMethodsSectionType.SECURITY_FOOTER.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public final ImmutableList mo652a(PickerScreenData pickerScreenData) {
        PaymentMethodsPickerScreenData paymentMethodsPickerScreenData = (PaymentMethodsPickerScreenData) pickerScreenData;
        Builder builder = new Builder();
        Iterator it = this.f15835b.m18837c(paymentMethodsPickerScreenData.f18845b.mo743a().f18786c).mo655a(paymentMethodsPickerScreenData).values().iterator();
        while (it.hasNext()) {
            PaymentMethodsSectionType paymentMethodsSectionType = (PaymentMethodsSectionType) it.next();
            switch (paymentMethodsSectionType) {
                case COUNTRY_SELECTOR:
                    mo1084a(builder, paymentMethodsPickerScreenData);
                    break;
                case SELECT_PAYMENT_METHOD:
                    m16026a(builder, paymentMethodsPickerScreenData, paymentMethodsPickerScreenData.f18845b);
                    break;
                case SINGLE_ROW_DIVIDER:
                    m16025a(builder);
                    break;
                case ADD_PAYMENT_METHOD:
                    m16027b(builder, paymentMethodsPickerScreenData, paymentMethodsPickerScreenData.f18845b);
                    break;
                case SECURITY_FOOTER:
                    builder.c(new PickerSecurityRowItem(this.f15834a.getString(2131233867)));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled section type " + paymentMethodsSectionType);
            }
        }
        return builder.b();
    }

    @Inject
    public PaymentMethodsRowItemsGenerator(Context context, SimplePickerScreenManager simplePickerScreenManager) {
        this.f15834a = context;
        this.f15835b = simplePickerScreenManager;
    }

    protected void mo1084a(Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData) {
        builder.c(new CountrySelectorRowItem(paymentMethodsPickerScreenData.f18845b.mo743a(), paymentMethodsPickerScreenData.f18844a.a, true));
    }

    private void m16026a(Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData, PickerScreenParams pickerScreenParams) {
        ImmutableList immutableList = paymentMethodsPickerScreenData.f18844a.d;
        if (!immutableList.isEmpty()) {
            PickerScreenCommonParams a = pickerScreenParams.mo743a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PaymentMethod paymentMethod = (PaymentMethod) immutableList.get(i);
                if (!a.f18788e.contains(paymentMethod.b().toNewPaymentOptionType())) {
                    if (paymentMethodsPickerScreenData.f18846c == null) {
                        builder.c(new PaymentMethodRowItem(paymentMethod, false, pickerScreenParams.mo743a()));
                    } else {
                        builder.c(new PaymentMethodRowItem(paymentMethod, paymentMethod.a().equals(paymentMethodsPickerScreenData.f18846c), pickerScreenParams.mo743a()));
                    }
                }
            }
            m16028c(builder, paymentMethodsPickerScreenData, pickerScreenParams);
        }
    }

    private void m16027b(Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData, PickerScreenParams pickerScreenParams) {
        if (!paymentMethodsPickerScreenData.f18844a.e.isEmpty()) {
            builder.c(new HeaderRowItem(this.f15834a.getString(2131233858)));
            m16028c(builder, paymentMethodsPickerScreenData, pickerScreenParams);
        }
    }

    private void m16028c(Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData, PickerScreenParams pickerScreenParams) {
        ImmutableList immutableList = paymentMethodsPickerScreenData.f18844a.e;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NewPaymentOption newPaymentOption = (NewPaymentOption) immutableList.get(i);
            if (!pickerScreenParams.mo743a().f18788e.contains(newPaymentOption.a())) {
                mo653a(newPaymentOption, builder, paymentMethodsPickerScreenData, pickerScreenParams);
            }
        }
    }

    protected void mo653a(NewPaymentOption newPaymentOption, Builder<RowItem> builder, PaymentMethodsPickerScreenData paymentMethodsPickerScreenData, PickerScreenParams pickerScreenParams) {
        switch (C21952.f18766b[newPaymentOption.a().ordinal()]) {
            case 1:
                return;
            case 2:
                builder.c(mo1083a(this.f15835b.m18841g(pickerScreenParams.mo743a().f18786c).mo654a(paymentMethodsPickerScreenData, pickerScreenParams), (NewCreditCardOption) FluentIterable.a(paymentMethodsPickerScreenData.f18844a.e).a(NewCreditCardOption.class).a().orNull()));
                return;
            case 3:
                AddPayPalRowItem.Builder newBuilder = AddPayPalRowItem.newBuilder();
                newBuilder.f18830a = paymentMethodsPickerScreenData.f18844a.c;
                newBuilder = newBuilder;
                newBuilder.f18831b = pickerScreenParams.mo743a().f18787d;
                newBuilder = newBuilder;
                newBuilder.f18832c = 2;
                newBuilder = newBuilder;
                newBuilder.f18833d = pickerScreenParams.mo743a();
                builder.c(newBuilder.m18844e());
                return;
            default:
                throw new IllegalArgumentException("Type " + newPaymentOption.a() + " is not to add a Payment method");
        }
    }

    protected AddCardRowItem mo1083a(Intent intent, NewCreditCardOption newCreditCardOption) {
        return new AddCardRowItem(intent, 1);
    }

    public static void m16025a(Builder<RowItem> builder) {
        builder.c(new C21941());
    }
}
