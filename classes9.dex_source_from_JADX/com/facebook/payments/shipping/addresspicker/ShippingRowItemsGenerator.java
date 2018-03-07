package com.facebook.payments.shipping.addresspicker;

import android.content.Context;
import android.content.Intent;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsRowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.RowItemsGenerator;
import com.facebook.payments.paymentmethods.picker.SimplePickerScreenManager;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.PickerSecurityRowItem;
import com.facebook.payments.picker.model.RowItem;
import com.facebook.payments.shipping.form.ShippingAddressActivity;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingAddressRowItem;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: backstage_user_update_whitelisted_friends */
public class ShippingRowItemsGenerator implements RowItemsGenerator<ShippingPickerScreenData> {
    public final Context f18910a;
    private final SimplePickerScreenManager f18911b;

    public final ImmutableList mo652a(PickerScreenData pickerScreenData) {
        ShippingPickerScreenData shippingPickerScreenData = (ShippingPickerScreenData) pickerScreenData;
        ShippingPickerScreenParams shippingPickerScreenParams = shippingPickerScreenData.f18895c;
        Builder builder = new Builder();
        Iterator it = this.f18911b.m18837c(shippingPickerScreenParams.mo743a().f18786c).mo655a(shippingPickerScreenData).values().iterator();
        while (it.hasNext()) {
            ShippingSectionType shippingSectionType = (ShippingSectionType) it.next();
            switch (shippingSectionType) {
                case SHIPPING_ADDRESSES:
                    m18917a(builder, shippingPickerScreenData);
                    break;
                case SHIPPING_SECURITY_MESSAGE:
                    builder.c(new PickerSecurityRowItem(this.f18910a.getString(2131240118)));
                    break;
                default:
                    throw new IllegalArgumentException("Unhandled section type " + shippingSectionType);
            }
        }
        return builder.b();
    }

    @Inject
    public ShippingRowItemsGenerator(Context context, SimplePickerScreenManager simplePickerScreenManager) {
        this.f18910a = context;
        this.f18911b = simplePickerScreenManager;
    }

    private void m18917a(Builder<RowItem> builder, ShippingPickerScreenData shippingPickerScreenData) {
        ShippingPickerScreenParams shippingPickerScreenParams = shippingPickerScreenData.f18895c;
        ImmutableList immutableList = shippingPickerScreenData.f18893a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MailingAddress mailingAddress = (MailingAddress) immutableList.get(i);
            builder.c(new ShippingAddressRowItem(shippingPickerScreenParams.f18899b.mo759a().f18991e, m18916a(shippingPickerScreenParams, mailingAddress), 102, mailingAddress, mailingAddress.mo761a("%s, %s, %s, %s"), mailingAddress.mo760a().equals(shippingPickerScreenData.f18894b)));
        }
        builder.c(new AddShippingAddressRowItem(shippingPickerScreenData.f18895c.f18899b));
        PaymentMethodsRowItemsGenerator.m16025a((Builder) builder);
    }

    private Intent m18916a(ShippingPickerScreenParams shippingPickerScreenParams, MailingAddress mailingAddress) {
        Context context = this.f18910a;
        ShippingCommonParamsBuilder newBuilder = ShippingCommonParams.newBuilder();
        ShippingCommonParams a = shippingPickerScreenParams.f18899b.mo759a();
        newBuilder.f18994a = a.f18987a;
        ShippingCommonParamsBuilder shippingCommonParamsBuilder = newBuilder;
        shippingCommonParamsBuilder.f18995b = a.f18988b;
        shippingCommonParamsBuilder = shippingCommonParamsBuilder;
        shippingCommonParamsBuilder.f18996c = a.f18989c;
        shippingCommonParamsBuilder = shippingCommonParamsBuilder;
        shippingCommonParamsBuilder.f18997d = a.f18990d;
        shippingCommonParamsBuilder = shippingCommonParamsBuilder;
        shippingCommonParamsBuilder.f19000g = a.f18993g;
        shippingCommonParamsBuilder = shippingCommonParamsBuilder;
        shippingCommonParamsBuilder.f18998e = a.f18991e;
        newBuilder = shippingCommonParamsBuilder;
        newBuilder.f18997d = mailingAddress;
        return ShippingAddressActivity.m18920a(context, newBuilder.m18972h());
    }
}
