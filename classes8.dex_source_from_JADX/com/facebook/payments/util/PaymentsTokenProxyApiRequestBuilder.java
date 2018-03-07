package com.facebook.payments.util;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;

/* compiled from: story_header_styles */
public class PaymentsTokenProxyApiRequestBuilder {
    public static ApiRequestBuilder m2251a(String str, Object... objArr) {
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.d = StringFormatUtil.a("ajax/payment/token_proxy.php?tpe=" + str, objArr);
        newBuilder = newBuilder;
        newBuilder.s = true;
        return newBuilder;
    }
}
