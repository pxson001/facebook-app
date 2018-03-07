package com.facebook.privacy.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: stickerId */
public final class ReportStickyGuardrailActionMethod implements ApiMethod<ReportStickyGuardrailActionParams, Boolean> {
    public final ApiRequest m6121a(Object obj) {
        ReportStickyGuardrailActionParams reportStickyGuardrailActionParams = (ReportStickyGuardrailActionParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("event", reportStickyGuardrailActionParams.f4179a));
        a.add(new BasicNameValuePair("client_time", Long.toString(reportStickyGuardrailActionParams.f4180b.longValue())));
        if (reportStickyGuardrailActionParams.f4181c.longValue() != 0) {
            a.add(new BasicNameValuePair("suggested_option_timestamp", Long.toString(reportStickyGuardrailActionParams.f4181c.longValue())));
        }
        if (reportStickyGuardrailActionParams.f4182d != null) {
            a.add(new BasicNameValuePair("from_privacy", reportStickyGuardrailActionParams.f4182d));
        }
        if (reportStickyGuardrailActionParams.f4183e != null) {
            a.add(new BasicNameValuePair("to_privacy", reportStickyGuardrailActionParams.f4183e));
        }
        a.add(new BasicNameValuePair("product", "fb4a_composer"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("reportStickyGuardrailAction", "POST", "me/sticky_guardrail_events", a, ApiResponseType.JSON);
    }

    public final Object m6122a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
