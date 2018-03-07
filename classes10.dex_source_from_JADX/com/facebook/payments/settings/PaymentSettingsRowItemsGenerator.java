package com.facebook.payments.settings;

import android.content.Context;
import com.facebook.payments.history.picker.ViewFullHistoryRowItem;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.RowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.AddCardRowItem;
import com.facebook.payments.paymentmethods.picker.model.AddPayPalRowItem;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodRowItem;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.HeaderRowItem;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.picker.model.RowType;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenData;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenFetcherParams;
import com.facebook.payments.settings.model.PaymentSettingsSectionType;
import com.facebook.payments.shipping.addresspicker.AddShippingAddressRowItem;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParams;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParamsBuilder;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingAddressRowItem;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: location_upsell_wizard */
public class PaymentSettingsRowItemsGenerator implements RowItemsGenerator<PaymentSettingsPickerScreenData> {
    public final Context f8438a;
    private final SimplePickerScreenManager f8439b;

    /* compiled from: location_upsell_wizard */
    public final class C12561 implements RowItem {
        public final RowType m8360a() {
            return RowType.SPACED_DOUBLE_ROW_DIVIDER;
        }
    }

    /* compiled from: location_upsell_wizard */
    /* synthetic */ class C12572 {
        static final /* synthetic */ int[] f8437b = new int[NewPaymentOptionType.values().length];

        static {
            try {
                f8437b[NewPaymentOptionType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8437b[NewPaymentOptionType.NEW_CREDIT_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8437b[NewPaymentOptionType.NEW_PAYPAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f8436a = new int[PaymentSettingsSectionType.values().length];
            try {
                f8436a[PaymentSettingsSectionType.PAYMENT_METHODS.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8436a[PaymentSettingsSectionType.PAYMENT_HISTORY.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8436a[PaymentSettingsSectionType.PERSONAL_INFORMATION.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8436a[PaymentSettingsSectionType.DOUBLE_ROW_DIVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public final ImmutableList m8367a(PickerScreenData pickerScreenData) {
        PaymentSettingsPickerScreenData paymentSettingsPickerScreenData = (PaymentSettingsPickerScreenData) pickerScreenData;
        Builder builder = new Builder();
        Iterator it = this.f8439b.c(paymentSettingsPickerScreenData.f8442c.a().c).a(paymentSettingsPickerScreenData).values().iterator();
        while (it.hasNext()) {
            PaymentSettingsSectionType paymentSettingsSectionType = (PaymentSettingsSectionType) it.next();
            switch (paymentSettingsSectionType) {
                case PAYMENT_METHODS:
                    m8363a(builder, paymentSettingsPickerScreenData, paymentSettingsPickerScreenData.f8442c);
                    break;
                case PAYMENT_HISTORY:
                    PickerScreenParams pickerScreenParams = paymentSettingsPickerScreenData.f8442c;
                    builder.c(new HeaderRowItem(this.f8438a.getString(2131241336)));
                    builder.c(new ViewFullHistoryRowItem(null, 401));
                    break;
                case PERSONAL_INFORMATION:
                    m8362a(builder, paymentSettingsPickerScreenData);
                    break;
                case DOUBLE_ROW_DIVIDER:
                    builder.c(new C12561());
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled section type " + paymentSettingsSectionType);
            }
        }
        return builder.b();
    }

    @Inject
    public PaymentSettingsRowItemsGenerator(Context context, SimplePickerScreenManager simplePickerScreenManager) {
        this.f8438a = context;
        this.f8439b = simplePickerScreenManager;
    }

    private void m8362a(Builder<RowItem> builder, PaymentSettingsPickerScreenData paymentSettingsPickerScreenData) {
        builder.c(new HeaderRowItem(this.f8438a.getString(2131241338)));
        if (paymentSettingsPickerScreenData.f8441b.isEmpty()) {
            builder.c(new AddShippingAddressRowItem(m8365c(paymentSettingsPickerScreenData)));
            return;
        }
        MailingAddress mailingAddress = (MailingAddress) paymentSettingsPickerScreenData.f8441b.get(0);
        ShippingSource shippingSource = ShippingSource.OTHERS;
        PickerScreenCommonParams a = paymentSettingsPickerScreenData.f8442c.a();
        PickerScreenCommonParamsBuilder newBuilder = PickerScreenCommonParams.newBuilder();
        newBuilder.b = a.a;
        newBuilder = newBuilder;
        newBuilder.a = a.b;
        newBuilder = newBuilder;
        newBuilder.c = PickerScreenStyle.SIMPLE_SHIPPING_ADDRESS;
        newBuilder = newBuilder;
        newBuilder.d = a.d;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder;
        pickerScreenCommonParamsBuilder.g = this.f8438a.getString(2131240117);
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.h = PaymentSettingsPickerScreenFetcherParams.newBuilder().m8372b();
        a = pickerScreenCommonParamsBuilder.j();
        ShippingPickerScreenParamsBuilder newBuilder2 = ShippingPickerScreenParams.newBuilder();
        newBuilder2.a = a;
        ShippingPickerScreenParamsBuilder shippingPickerScreenParamsBuilder = newBuilder2;
        shippingPickerScreenParamsBuilder.b = m8365c(paymentSettingsPickerScreenData);
        shippingPickerScreenParamsBuilder = shippingPickerScreenParamsBuilder;
        shippingPickerScreenParamsBuilder.c = paymentSettingsPickerScreenData.f8441b;
        builder.c(new ShippingAddressRowItem(shippingSource, PickerScreenActivity.a(this.f8438a, shippingPickerScreenParamsBuilder.e()), 402, mailingAddress, mailingAddress.a("%s (%s, %s, %s, %s)"), false));
    }

    private void m8363a(Builder<RowItem> builder, PaymentSettingsPickerScreenData paymentSettingsPickerScreenData, PickerScreenParams pickerScreenParams) {
        if (!paymentSettingsPickerScreenData.f8440a.e.isEmpty()) {
            builder.c(new HeaderRowItem(this.f8438a.getString(2131233858)));
            m8364b(builder, paymentSettingsPickerScreenData, pickerScreenParams);
            m8366c(builder, paymentSettingsPickerScreenData, pickerScreenParams);
        }
    }

    private static void m8364b(Builder<RowItem> builder, PaymentSettingsPickerScreenData paymentSettingsPickerScreenData, PickerScreenParams pickerScreenParams) {
        ImmutableList immutableList = paymentSettingsPickerScreenData.f8440a.d;
        if (!immutableList.isEmpty()) {
            PickerScreenCommonParams a = pickerScreenParams.a();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                PaymentMethod paymentMethod = (PaymentMethod) immutableList.get(i);
                if (!a.e.contains(paymentMethod.b().toNewPaymentOptionType())) {
                    builder.c(new PaymentMethodRowItem(paymentMethod, false, pickerScreenParams.a()));
                }
            }
        }
    }

    private void m8366c(Builder<RowItem> builder, PaymentSettingsPickerScreenData paymentSettingsPickerScreenData, PickerScreenParams pickerScreenParams) {
        ImmutableList immutableList = paymentSettingsPickerScreenData.f8440a.e;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NewPaymentOption newPaymentOption = (NewPaymentOption) immutableList.get(i);
            if (!pickerScreenParams.a().e.contains(newPaymentOption.a())) {
                m8361a(newPaymentOption, builder, paymentSettingsPickerScreenData, pickerScreenParams);
            }
        }
    }

    private void m8361a(NewPaymentOption newPaymentOption, Builder<RowItem> builder, PaymentSettingsPickerScreenData paymentSettingsPickerScreenData, PickerScreenParams pickerScreenParams) {
        switch (C12572.f8437b[newPaymentOption.a().ordinal()]) {
            case 1:
                return;
            case 2:
                builder.c(new AddCardRowItem(this.f8439b.g(pickerScreenParams.a().c).a(paymentSettingsPickerScreenData, pickerScreenParams), 1));
                return;
            case 3:
                AddPayPalRowItem.Builder newBuilder = AddPayPalRowItem.newBuilder();
                newBuilder.a = paymentSettingsPickerScreenData.f8440a.c;
                newBuilder = newBuilder;
                newBuilder.b = pickerScreenParams.a().d;
                newBuilder = newBuilder;
                newBuilder.c = 2;
                newBuilder = newBuilder;
                newBuilder.d = pickerScreenParams.a();
                builder.c(newBuilder.e());
                return;
            default:
                throw new IllegalArgumentException("Type " + newPaymentOption.a() + " is not to add a Payment method");
        }
    }

    public static ShippingCommonParams m8365c(PaymentSettingsPickerScreenData paymentSettingsPickerScreenData) {
        ShippingCommonParamsBuilder newBuilder = ShippingCommonParams.newBuilder();
        newBuilder.a = ShippingStyle.MESSENGER_COMMERCE;
        newBuilder = newBuilder;
        newBuilder.b = paymentSettingsPickerScreenData.f8440a.a;
        newBuilder = newBuilder;
        newBuilder.e = ShippingSource.OTHERS;
        newBuilder = newBuilder;
        newBuilder.g = paymentSettingsPickerScreenData.f8441b.size();
        return newBuilder.h();
    }
}
