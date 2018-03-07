package com.facebook.messaging.payment.pin.protocol.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.payment.pin.model.UpdatePaymentPinStatusParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* compiled from: groups_section */
public class UpdatePaymentPinStatusMethod implements ApiMethod<UpdatePaymentPinStatusParams, Boolean> {
    public final ApiRequest m14319a(Object obj) {
        UpdatePaymentPinStatusParams updatePaymentPinStatusParams = (UpdatePaymentPinStatusParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("old_pin", updatePaymentPinStatusParams.f13724c));
        if (!StringUtil.a(updatePaymentPinStatusParams.f13725d)) {
            a.add(new BasicNameValuePair("new_pin", updatePaymentPinStatusParams.f13725d));
        }
        if (updatePaymentPinStatusParams.f13726e != null && updatePaymentPinStatusParams.f13726e.isSet()) {
            a.add(new BasicNameValuePair("payments_protected", updatePaymentPinStatusParams.f13726e.asBooleanObject().toString()));
        }
        if (!(updatePaymentPinStatusParams.m14265e() == null || updatePaymentPinStatusParams.m14265e().isEmpty())) {
            a.add(new BasicNameValuePair("thread_profiles_protected", new JSONObject(updatePaymentPinStatusParams.m14265e()).toString()));
        }
        a.add(new BasicNameValuePair("format", "json"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update_payment_pin_status";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d", Long.valueOf(updatePaymentPinStatusParams.f13723b));
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m14320a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
