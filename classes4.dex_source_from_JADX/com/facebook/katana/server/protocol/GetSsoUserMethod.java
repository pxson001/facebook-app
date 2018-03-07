package com.facebook.katana.server.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: target_uid */
public class GetSsoUserMethod implements ApiMethod<String, Result> {
    public static GetSsoUserMethod m1529a(InjectorLike injectorLike) {
        return new GetSsoUserMethod();
    }

    public final ApiRequest m1530a(Object obj) {
        return new ApiRequest("getSsoUserMethod", TigonRequest.POST, "method/fql.query", ImmutableList.of(new BasicNameValuePair("query", "SELECT username, name FROM user WHERE uid=me()"), new BasicNameValuePair("access_token", (String) obj), new BasicNameValuePair("format", "json")), ApiResponseType.JSON);
    }

    public final Object m1531a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode a = apiResponse.c().a(0);
        return new Result(a.b("username").s(), a.b("name").s());
    }
}
