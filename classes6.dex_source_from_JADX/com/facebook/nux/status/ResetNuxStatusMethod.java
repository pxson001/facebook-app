package com.facebook.nux.status;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import java.util.ArrayList;

/* compiled from: isDefault */
public class ResetNuxStatusMethod implements ApiMethod<Void, Boolean> {
    public final ApiRequest m19165a(Object obj) {
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "resetNuxStatus";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/nux_wizard_user_state";
        newBuilder = newBuilder;
        newBuilder.g = new ArrayList();
        newBuilder = newBuilder.a(RequestPriority.INTERACTIVE);
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m19166a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c().f("success")));
    }
}
