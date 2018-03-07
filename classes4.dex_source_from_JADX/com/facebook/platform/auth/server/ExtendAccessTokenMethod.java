package com.facebook.platform.auth.server;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: game_data */
public class ExtendAccessTokenMethod implements ApiMethod<Params, Result> {
    public final ApiRequest m11749a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("access_token", params.a));
        a.add(new BasicNameValuePair("fb_access_token", params.b));
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("grant_type", "fb_extend_sso_token"));
        return new ApiRequest("extend_access_token_method", TigonRequest.GET, "oauth/access_token", a, ApiResponseType.JSON);
    }

    public final Object m11750a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        return new Result(c.b("access_token").B(), c.b("expires_at").D());
    }
}
