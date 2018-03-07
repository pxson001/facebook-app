package com.facebook.commerce.storefront.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: createNewGroupEvent */
public class MerchantSubscriptionStatusUpdateMethod implements ApiMethod<MerchantSubscriptionParams, String> {
    public final ApiRequest m16144a(Object obj) {
        MerchantSubscriptionParams merchantSubscriptionParams = (MerchantSubscriptionParams) obj;
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("settings_id", merchantSubscriptionParams.f15694a));
        arrayList.add(new BasicNameValuePair("status", merchantSubscriptionParams.f15695b));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "update_merchant_subscription_status";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/commerce_merchant_subscriptions";
        newBuilder = newBuilder;
        newBuilder.g = arrayList;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m16145a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        apiResponse.i();
        if (c.b("success") != null) {
            return c.b("success").B();
        }
        return null;
    }
}
