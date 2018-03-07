package com.facebook.rtc.voicemail.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: appContext */
public class VoicemailPromptDeleteMethod implements ApiMethod<String, Boolean> {
    public static VoicemailPromptDeleteMethod m19942a(InjectorLike injectorLike) {
        return new VoicemailPromptDeleteMethod();
    }

    public final ApiRequest m19943a(Object obj) {
        String str = (String) obj;
        List a = Lists.a();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "custom_voicemail_delete";
        newBuilder = newBuilder;
        newBuilder.c = "DELETE";
        newBuilder = newBuilder;
        newBuilder.d = str;
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m19944a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.c().toString()));
    }
}
