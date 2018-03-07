package com.facebook.messaging.service.methods;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.FetchGroupInviteLinkParams;
import java.util.ArrayList;

/* compiled from: date ASC */
public class FetchGroupInviteLinkMethod implements ApiMethod<FetchGroupInviteLinkParams, String> {
    public final ApiRequest m16886a(Object obj) {
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("t_id.%d/invites", Long.valueOf(((FetchGroupInviteLinkParams) obj).f17052b.i()));
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        apiRequestBuilder.b = "fetchGroupInviteLink";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.c = "POST";
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = new ArrayList();
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.d = formatStrLocaleSafe;
        ApiRequestBuilder apiRequestBuilder2 = apiRequestBuilder;
        apiRequestBuilder2.k = ApiResponseType.JSON;
        return apiRequestBuilder2.C();
    }

    public final Object m16887a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return JSONUtil.b(apiResponse.c().b("invite_link"));
    }
}
