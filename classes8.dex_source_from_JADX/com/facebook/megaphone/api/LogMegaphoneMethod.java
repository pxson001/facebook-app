package com.facebook.megaphone.api;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: typeahead_text */
public class LogMegaphoneMethod implements ApiMethod<LogMegaphoneParams, Void> {
    public final ApiRequest m1512a(Object obj) {
        LogMegaphoneParams logMegaphoneParams = (LogMegaphoneParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        String a2 = StringFormatUtil.a("me/megaphones/%s", new Object[]{logMegaphoneParams.f1278a});
        a.add(new BasicNameValuePair("log_event", logMegaphoneParams.f1279b.toString()));
        a.add(new BasicNameValuePair("log_data", JSONUtil.a(logMegaphoneParams.f1280c).toString()));
        return new ApiRequest("LogMegaphoneMethod", "POST", a2, a, ApiResponseType.JSON);
    }

    public final Object m1513a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
