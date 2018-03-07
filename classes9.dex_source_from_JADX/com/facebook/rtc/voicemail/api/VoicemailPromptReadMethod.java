package com.facebook.rtc.voicemail.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: apns */
public class VoicemailPromptReadMethod implements ApiMethod<String, Result> {

    @Immutable
    /* compiled from: apns */
    public class Result {
        private final String f20382a;
        private final String f20383b;
        private final String f20384c;

        public Result(String str, String str2, String str3) {
            this.f20382a = str;
            this.f20383b = str2;
            this.f20384c = str3;
        }

        public final String m19945a() {
            return this.f20384c;
        }
    }

    public final ApiRequest m19946a(Object obj) {
        String str = (String) obj;
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("fields", "custom_voicemail"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "custom_voicemail_read";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    @Nullable
    public final Object m19947a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        if (!c.d("custom_voicemail")) {
            return null;
        }
        c = c.b("custom_voicemail");
        return new Result(c.b("id").s(), c.b("extension").s(), c.b("uri").s());
    }
}
