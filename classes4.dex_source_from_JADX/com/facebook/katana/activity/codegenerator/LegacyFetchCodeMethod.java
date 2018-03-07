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

/* compiled from: sms_detected */
public class LegacyFetchCodeMethod implements ApiMethod<LegacyFetchCodeParams, FetchCodeResult> {
    public final ApiRequest m2213a(Object obj) {
        LegacyFetchCodeParams legacyFetchCodeParams = (LegacyFetchCodeParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(legacyFetchCodeParams);
        Preconditions.checkNotNull(legacyFetchCodeParams.f2067a);
        Preconditions.checkNotNull(legacyFetchCodeParams.f2068b);
        a.add(new BasicNameValuePair("machine_id", legacyFetchCodeParams.f2068b));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphUserLoginApprovalsKeysPost", TigonRequest.POST, StringFormatUtil.a("/%s/loginapprovalskeys", new Object[]{legacyFetchCodeParams.f2067a}), a, ApiResponseType.JSON);
    }

    public final Object m2214a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        String b = JSONUtil.b(c.b("key"));
        return new FetchCodeResult(CodeGeneratorValidator.m2399b(b), JSONUtil.b(c.b("time_offset")));
    }
}
