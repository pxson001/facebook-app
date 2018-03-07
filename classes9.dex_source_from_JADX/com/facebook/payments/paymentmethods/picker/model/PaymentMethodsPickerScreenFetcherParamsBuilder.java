package com.facebook.payments.paymentmethods.picker.model;

import com.facebook.common.locale.Country;
import org.json.JSONObject;

/* compiled from: block_time */
public class PaymentMethodsPickerScreenFetcherParamsBuilder {
    public boolean f18850a;
    public JSONObject f18851b;
    public Country f18852c;

    public final PaymentMethodsPickerScreenFetcherParamsBuilder m18854a(boolean z) {
        this.f18850a = z;
        return this;
    }

    public final PaymentMethodsPickerScreenFetcherParamsBuilder m18853a(JSONObject jSONObject) {
        this.f18851b = jSONObject;
        return this;
    }

    public final PaymentMethodsPickerScreenFetcherParams m18855d() {
        return new PaymentMethodsPickerScreenFetcherParams(this);
    }
}
