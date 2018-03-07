package com.facebook.messaging.payment.value.input;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.locale.Country;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.util.PaymentFlowTypeUtil;
import com.facebook.payments.model.PaymentItemType;
import com.facebook.payments.model.PaymentsFlowType;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParams;
import com.facebook.payments.shipping.addresspicker.ShippingPickerScreenParamsBuilder;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingCommonParamsBuilder;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.shipping.model.ShippingStyle;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: exception_info */
public class MessengerPayPickerScreenParamHelper {
    public final Resources f15469a;

    public static MessengerPayPickerScreenParamHelper m15768a(InjectorLike injectorLike) {
        return new MessengerPayPickerScreenParamHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerPayPickerScreenParamHelper(Resources resources) {
        this.f15469a = resources;
    }

    public final ShippingPickerScreenParams m15772a(ImmutableList<MailingAddress> immutableList, @Nullable String str, String str2, boolean z, Country country) {
        ShippingPickerScreenParamsBuilder newBuilder = ShippingPickerScreenParams.newBuilder();
        newBuilder.f18902a = m15770a(PickerScreenStyle.SIMPLE_SHIPPING_ADDRESS, this.f15469a.getString(2131240117), str2, z);
        newBuilder = newBuilder;
        ShippingCommonParamsBuilder newBuilder2 = ShippingCommonParams.newBuilder();
        newBuilder2.f18994a = ShippingStyle.MESSENGER_COMMERCE;
        newBuilder2 = newBuilder2;
        newBuilder2.f18995b = country;
        newBuilder2 = newBuilder2;
        newBuilder2.f18998e = ShippingSource.CHECKOUT;
        newBuilder2 = newBuilder2;
        newBuilder2.f19000g = immutableList.size();
        newBuilder.f18903b = newBuilder2.m18972h();
        newBuilder = newBuilder;
        newBuilder.f18904c = immutableList;
        newBuilder = newBuilder;
        newBuilder.f18905d = str;
        return newBuilder.m18909e();
    }

    public final PickerScreenCommonParams m15771a(MessengerPayType messengerPayType, @Nullable String str, Optional<PaymentMethod> optional, String str2) {
        String string;
        JSONObject jSONObject = null;
        PickerScreenStyleParams c = PickerScreenStyleParams.newBuilder().m18826a(optional.isPresent() ? (PaymentMethod) optional.get() : jSONObject).m18827c();
        if (optional.isPresent()) {
            string = this.f15469a.getString(2131233858);
        } else {
            string = this.f15469a.getString(2131233857);
        }
        ImmutableList of = ImmutableList.of(NewPaymentOptionType.NEW_PAYPAL);
        if (!messengerPayType.equals(MessengerPayType.PAGES_COMMERCE)) {
            return PickerScreenCommonParams.newBuilder().m18793a(m15769a(str2)).m18795a(c).m18794a(PickerScreenStyle.MESSENGER_COMMERCE).m18792a(PaymentItemType.MESSENGER_COMMERCE).m18797a(of).m18796a(PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d()).m18798b(string).m18799j();
        }
        try {
            jSONObject = new JSONObject().put("invoice_id", str);
        } catch (JSONException e) {
        }
        return PickerScreenCommonParams.newBuilder().m18793a(m15769a(str2)).m18795a(c).m18794a(PickerScreenStyle.MESSENGER_COMMERCE).m18792a(PaymentItemType.PAGES_COMMERCE).m18797a(of).m18796a(PaymentMethodsPickerScreenFetcherParams.newBuilder().m18854a(false).m18853a(jSONObject).m18855d()).m18798b(string).m18799j();
    }

    private static PickerScreenAnalyticsParams m15769a(String str) {
        PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
        newBuilder.f18780a = str;
        newBuilder = newBuilder;
        newBuilder.f18782c = PaymentsFlowType.CHECKOUT_FLOW;
        return newBuilder.m18789e();
    }

    public static PickerScreenCommonParams m15770a(PickerScreenStyle pickerScreenStyle, String str, String str2, boolean z) {
        PickerScreenCommonParamsBuilder newBuilder = PickerScreenCommonParams.newBuilder();
        newBuilder.f18794b = PickerScreenStyleParams.newBuilder().m18827c();
        newBuilder = newBuilder;
        newBuilder.f18793a = m15769a(str2);
        newBuilder = newBuilder;
        newBuilder.f18795c = pickerScreenStyle;
        newBuilder = newBuilder;
        newBuilder.f18796d = PaymentFlowTypeUtil.m15515a(z);
        newBuilder = newBuilder;
        newBuilder.f18799g = str;
        newBuilder = newBuilder;
        newBuilder.f18800h = PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d();
        return newBuilder.m18799j();
    }
}
