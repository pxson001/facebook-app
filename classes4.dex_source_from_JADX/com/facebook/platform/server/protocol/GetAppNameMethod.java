package com.facebook.platform.server.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: gc_total_count */
public class GetAppNameMethod implements ApiMethod<Params, String> {
    private static final Class<?> f11314a = GetAppNameMethod.class;

    public static GetAppNameMethod m11732a(InjectorLike injectorLike) {
        return new GetAppNameMethod();
    }

    public final ApiRequest m11733a(Object obj) {
        Params params = (Params) obj;
        Preconditions.checkNotNull(params);
        Preconditions.checkNotNull(params.a);
        String str = params.a;
        List a = Lists.a();
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "getAppName";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.GET;
        newBuilder = newBuilder;
        newBuilder.d = params.a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = a;
        return newBuilder.C();
    }

    public final Object m11734a(Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("name").B();
    }
}
