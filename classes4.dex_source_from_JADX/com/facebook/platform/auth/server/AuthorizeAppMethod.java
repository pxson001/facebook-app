package com.facebook.platform.auth.server;

import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: gatekeepes_fetches */
public class AuthorizeAppMethod implements ApiMethod<Params, Result> {
    public final ApiRequest m11744a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("proxied_app_id", params.a));
        a.add(new BasicNameValuePair("android_key_hash", params.b));
        if (params.c.isPresent()) {
            a.add(new BasicNameValuePair("permissions", (String) params.c.get()));
        }
        if (params.d.isPresent()) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("value", (String) params.d.get());
            a.add(new BasicNameValuePair("write_privacy", objectNode.toString()));
        }
        if (params.e.isPresent()) {
            a.add(new BasicNameValuePair("is_refresh_only", ((Boolean) params.e.get()).toString()));
        }
        return new ApiRequest("authorize_app_method", TigonRequest.POST, "method/auth.androidauthorizeapp", a, ApiResponseType.JSON);
    }

    public final Object m11745a(Object obj, ApiResponse apiResponse) {
        JsonNode jsonNode;
        if (apiResponse.c instanceof JsonNode) {
            jsonNode = (JsonNode) apiResponse.c;
            if (jsonNode != null && jsonNode.i() && jsonNode.d("error_code") && JSONUtil.d(jsonNode.c("error_code")) == 408) {
                return null;
            }
        }
        apiResponse.i();
        jsonNode = apiResponse.c();
        String B = jsonNode.b("access_token").B();
        long D = jsonNode.b("expires").D();
        List a = Lists.a();
        Iterator it = jsonNode.b("permissions").iterator();
        while (it.hasNext()) {
            a.add(((JsonNode) it.next()).B());
        }
        return new Result(B, D, a);
    }
}
