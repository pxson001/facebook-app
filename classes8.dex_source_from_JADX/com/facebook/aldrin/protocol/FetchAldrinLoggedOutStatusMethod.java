package com.facebook.aldrin.protocol;

import com.facebook.aldrin.status.AldrinUserStatus;
import com.facebook.aldrin.status.AldrinUserStatusBuilder;
import com.facebook.common.time.Clock;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: like_comment_tap */
public class FetchAldrinLoggedOutStatusMethod implements ApiMethod<Void, AldrinUserStatus> {
    private final Clock f10355a;

    @Inject
    public FetchAldrinLoggedOutStatusMethod(Clock clock) {
        this.f10355a = clock;
    }

    public final ApiRequest m12164a(Object obj) {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "getAldrinLoggedOutUser";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "GET";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = "aldrin_logged_out_status";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = new ArrayList();
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m12165a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode a = apiResponse.c().b("data").a(0);
        AldrinUserStatusBuilder aldrinUserStatusBuilder = new AldrinUserStatusBuilder();
        aldrinUserStatusBuilder.f10378e = JSONUtil.g(a.b("should_be_cu"));
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder.f10379f = JSONUtil.b(a.b("tos_terms_url"));
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder.f10380g = JSONUtil.b(a.b("tos_privacy_url"));
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder.f10381h = JSONUtil.b(a.b("tos_cookies_url"));
        aldrinUserStatusBuilder = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder.f10382i = JSONUtil.b(a.b("tos_version"));
        AldrinUserStatusBuilder aldrinUserStatusBuilder2 = aldrinUserStatusBuilder;
        aldrinUserStatusBuilder2.f10383j = this.f10355a.a();
        return aldrinUserStatusBuilder2.m12181l();
    }
}
