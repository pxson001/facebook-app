package com.facebook.payments.checkout.recyclerview;

import android.content.res.Resources;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.decorator.PaymentsDecoratorAnimation;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.decorator.PaymentsDecoratorParams.Builder;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParamsBuilder;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: entry_point_ref */
public class SimpleCheckoutSubScreenParamsGenerator {
    public final Resources f15734a;

    @Inject
    public SimpleCheckoutSubScreenParamsGenerator(Resources resources) {
        this.f15734a = resources;
    }

    protected ImmutableList<NewPaymentOptionType> mo634d() {
        return RegularImmutableList.a;
    }

    public ShippingStyle mo644a() {
        return ShippingStyle.SIMPLE;
    }

    public final PickerScreenParams m15905d(CheckoutData checkoutData) {
        PaymentMethod paymentMethod;
        PaymentItemType paymentItemType = checkoutData.mo717a().mo627a().f18460b;
        PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
        newBuilder.f18780a = paymentItemType.getValue();
        newBuilder = newBuilder;
        newBuilder.f18782c = PaymentsFlowType.CHECKOUT_FLOW;
        PickerScreenAnalyticsParams e = newBuilder.m18789e();
        Builder a = PaymentsDecoratorParams.newBuilder().a(checkoutData.mo717a().mo627a().f18462d);
        a.a = PaymentsDecoratorAnimation.SLIDE_RIGHT;
        PaymentsDecoratorParams c = a.c();
        PickerScreenStyleParamsBuilder newBuilder2 = PickerScreenStyleParams.newBuilder();
        if (checkoutData.mo728l().isPresent()) {
            paymentMethod = (PaymentMethod) checkoutData.mo728l().get();
        } else {
            paymentMethod = null;
        }
        newBuilder2.f18815b = paymentMethod;
        PickerScreenStyleParamsBuilder pickerScreenStyleParamsBuilder = newBuilder2;
        pickerScreenStyleParamsBuilder.f18814a = c;
        PickerScreenStyleParams c2 = pickerScreenStyleParamsBuilder.m18827c();
        String string = (checkoutData.mo729m() == null || checkoutData.mo729m().isEmpty()) ? this.f15734a.getString(2131233857) : this.f15734a.getString(2131233858);
        PickerScreenCommonParamsBuilder newBuilder3 = PickerScreenCommonParams.newBuilder();
        newBuilder3.f18793a = e;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder3;
        pickerScreenCommonParamsBuilder.f18794b = c2;
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18795c = mo633b();
        pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder.f18796d = paymentItemType;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder2 = pickerScreenCommonParamsBuilder;
        pickerScreenCommonParamsBuilder2.f18799g = string;
        PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder2;
        pickerScreenCommonParamsBuilder3.f18800h = PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d();
        pickerScreenCommonParamsBuilder3 = pickerScreenCommonParamsBuilder3;
        pickerScreenCommonParamsBuilder3.f18797e = mo634d();
        return pickerScreenCommonParamsBuilder3.m18799j();
    }

    protected PickerScreenStyle mo633b() {
        return PickerScreenStyle.PAYMENT_METHODS;
    }

    public PickerScreenStyle mo645c() {
        return PickerScreenStyle.SIMPLE_SHIPPING_OPTION_PICKER;
    }
}
