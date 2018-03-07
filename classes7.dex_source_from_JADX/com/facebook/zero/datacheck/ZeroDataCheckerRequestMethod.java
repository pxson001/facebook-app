package com.facebook.zero.datacheck;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;

/* compiled from: ो */
public class ZeroDataCheckerRequestMethod implements ApiMethod<Void, Void> {
    private static final Class<?> f102a = ZeroDataCheckerRequestMethod.class;

    public final ApiRequest m95a(Object obj) {
        return new ApiRequest(f102a.getSimpleName(), "GET", "method/mobile.zeroBalanceDetection", RequestPriority.DEFAULT_PRIORITY, Lists.a(), ApiResponseType.STRING);
    }

    public final Object m96a(Object obj, ApiResponse apiResponse) {
        return null;
    }
}
