package com.facebook.katana.login.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: sms_anonymous_promo_set_time */
public class LoginBroadcastEligibilityCheckMethod implements ApiMethod<Void, LoginBroadcastEligibilityResult> {
    public final ApiRequest m2222a(Object obj) {
        List arrayList = new ArrayList();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "fetchBroadcastEligibility";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = "/me/?fields=messenger_multi_account_push_notification_upsell_eligibility";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m2223a(Object obj, ApiResponse apiResponse) {
        return new LoginBroadcastEligibilityResult(apiResponse.c().b("messenger_multi_account_push_notification_upsell_eligibility").F());
    }
}
