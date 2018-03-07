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

/* compiled from: sms_debug_msg_errors/ */
public class LegacyCheckCodeMethod implements ApiMethod<CheckCodeParams, CheckCodeResult> {
    public final ApiRequest m2215a(Object obj) {
        CheckCodeParams checkCodeParams = (CheckCodeParams) obj;
        List a = Lists.a();
        Preconditions.checkNotNull(checkCodeParams);
        Preconditions.checkNotNull(checkCodeParams.a);
        Preconditions.checkNotNull(checkCodeParams.b);
        Preconditions.checkNotNull(checkCodeParams.c);
        a.add(new BasicNameValuePair("check_code", checkCodeParams.b));
        a.add(new BasicNameValuePair("client_time", checkCodeParams.c));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("graphUserLoginApprovalsKeysPost", TigonRequest.POST, StringFormatUtil.a("/%s/loginapprovalskeys", new Object[]{checkCodeParams.a}), a, ApiResponseType.JSON);
    }

    public final Object m2216a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        JsonNode c = apiResponse.c();
        return new CheckCodeResult(JSONUtil.b(c.b("code_valid")), JSONUtil.b(c.b("time_offset")));
    }
}
