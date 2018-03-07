package com.facebook.messaging.payment.protocol.cards;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.service.model.cards.EditPaymentCardParams;
import com.facebook.payments.util.PaymentsTokenProxyApiRequestBuilder;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: foreground_battery_drain */
public class EditPaymentCardMethod implements ApiMethod<EditPaymentCardParams, String> {
    private static final Class<?> f14578a = EditPaymentCardMethod.class;

    public static EditPaymentCardMethod m15023a(InjectorLike injectorLike) {
        return new EditPaymentCardMethod();
    }

    public final ApiRequest m15024a(Object obj) {
        String str;
        EditPaymentCardParams editPaymentCardParams = (EditPaymentCardParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("month", String.valueOf(editPaymentCardParams.f14629b)));
        a.add(new BasicNameValuePair("year", String.valueOf(editPaymentCardParams.f14630c)));
        a.add(new BasicNameValuePair("csc", editPaymentCardParams.f14631d));
        if (editPaymentCardParams.f14632e != null) {
            a.add(new BasicNameValuePair("zip", editPaymentCardParams.f14632e));
        }
        String str2 = "mobile_eligibility";
        if (editPaymentCardParams.f14633f) {
            str = "1";
        } else {
            str = "0";
        }
        a.add(new BasicNameValuePair(str2, str));
        ApiRequestBuilder a2 = PaymentsTokenProxyApiRequestBuilder.a("/p2p_%s", new Object[]{editPaymentCardParams.f14628a});
        a2.b = "p2p_edit_cards";
        a2 = a2;
        a2.c = "POST";
        a2 = a2;
        a2.g = a;
        a2 = a2;
        a2.k = ApiResponseType.JSON;
        return a2.C();
    }

    public final Object m15025a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return JSONUtil.b(apiResponse.c().b("credential_id"));
    }
}
