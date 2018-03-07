package com.facebook.push.fbpushtoken;

import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: iab_pref_disabled */
public class RegisterPushTokenMethod implements ApiMethod<RegisterPushTokenParams, RegisterPushTokenResult> {
    public final ApiRequest m11091a(Object obj) {
        RegisterPushTokenParams registerPushTokenParams = (RegisterPushTokenParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("return_structure", "1"));
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        String str = registerPushTokenParams.f10522d;
        if (!StringUtil.a(str)) {
            objectNode.a("url", str);
        }
        objectNode.a("token", registerPushTokenParams.f10520b);
        objectNode.a("device_id", registerPushTokenParams.f10521c);
        objectNode.a("is_initial_reg", registerPushTokenParams.f10523e);
        ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
        objectNode2.a("android_build", registerPushTokenParams.f10524f);
        objectNode2.a("android_setting_mask", registerPushTokenParams.f10525g);
        objectNode2.a("orca_muted_until_ms", registerPushTokenParams.f10526h);
        objectNode.c("extra_data", objectNode2);
        a.add(new BasicNameValuePair("protocol_params", objectNode.toString()));
        return new ApiRequest("registerPush", TigonRequest.POST, "method/user.registerPushCallback", a, ApiResponseType.JSON);
    }

    public final Object m11092a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        return new RegisterPushTokenResult(JSONUtil.g(c.b("success")), JSONUtil.g(c.b("previously_disabled")), System.currentTimeMillis());
    }
}
