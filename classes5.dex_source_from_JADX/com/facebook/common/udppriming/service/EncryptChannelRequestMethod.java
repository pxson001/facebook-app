package com.facebook.common.udppriming.service;

import com.facebook.common.udppriming.client.EncryptChannelInformation;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.FallbackBehavior;
import com.facebook.http.protocol.UDPPrimingHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: should_show_recent_activity_entry_point */
public class EncryptChannelRequestMethod implements ApiMethod<String, Void> {
    private final UDPPrimingHelper f2738a;

    public final ApiRequest m3859a(Object obj) {
        String str = (String) obj;
        List a = Lists.a(1);
        if (str != null) {
            a.add(new BasicNameValuePair("channel_id", str));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "encryptChannelRequestMethod";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "/me/encryptedchannels";
        newBuilder = newBuilder.a(RequestPriority.CAN_WAIT);
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.e = this.f2738a.b;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.v = FallbackBehavior.FALLBACK_REQUIRED;
        return apiRequestBuilder.C();
    }

    @Inject
    public EncryptChannelRequestMethod(UDPPrimingHelper uDPPrimingHelper) {
        this.f2738a = uDPPrimingHelper;
    }

    public final Object m3860a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        EncryptChannelInformation.a.a(JSONUtil.b(c.b("fbid")), JSONUtil.b(c.b("client_mac_key")), JSONUtil.b(c.b("client_encryption_key")), this.f2738a.d(), JSONUtil.d(c.b("ttl")) * 1000, JSONUtil.d(c.b("ttl_after_first_use")) * 1000, JSONUtil.d(c.b("algorithm_version")), JSONUtil.c(c.b("creation_time")) * 1000);
        return null;
    }
}
