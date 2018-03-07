package com.facebook.katana.activity.codegenerator;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sms_device_status_reported */
public class FetchCodeMethod implements ApiMethod<FetchCodeParams, FetchCodeResult> {
    public final ApiRequest m2211a(Object obj) {
        FetchCodeParams fetchCodeParams = (FetchCodeParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(fetchCodeParams);
        Preconditions.checkNotNull(fetchCodeParams.a);
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("client_time", fetchCodeParams.b));
        if (fetchCodeParams.c) {
            a.add(new BasicNameValuePair("send_sms", "1"));
        }
        return new ApiRequest("graphUserTOTPKeysPost", TigonRequest.POST, StringFormatUtil.a("/%s/totpkeys", new Object[]{fetchCodeParams.a}), a, ApiResponseType.JSON);
    }

    public final Object m2212a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("key"));
        return new FetchCodeResult(CodeGeneratorValidator.m2399b(b), JSONUtil.b(c.b("time_offset")));
    }
}
