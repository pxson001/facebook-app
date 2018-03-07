package com.facebook.privacy.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: stereomode */
public final class ReportStickyUpsellActionMethod implements ApiMethod<ReportStickyUpsellActionParams, Boolean> {
    public final ApiRequest m6123a(Object obj) {
        ReportStickyUpsellActionParams reportStickyUpsellActionParams = (ReportStickyUpsellActionParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("event", reportStickyUpsellActionParams.f4184a));
        a.add(new BasicNameValuePair("client_time", Long.toString(reportStickyUpsellActionParams.f4185b.longValue())));
        a.add(new BasicNameValuePair("product", reportStickyUpsellActionParams.f4188e));
        if (reportStickyUpsellActionParams.f4186c != null) {
            a.add(new BasicNameValuePair("from_privacy", reportStickyUpsellActionParams.f4186c));
        }
        if (reportStickyUpsellActionParams.f4187d != null) {
            a.add(new BasicNameValuePair("to_privacy", reportStickyUpsellActionParams.f4187d));
        }
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("reportStickyUpsellAction", "POST", "me/sticky_upsell_events", a, ApiResponseType.JSON);
    }

    public final Object m6124a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
