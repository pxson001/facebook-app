package com.facebook.privacy.protocol;

import android.text.TextUtils;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sticker_assets */
public final class ReportNASActionMethod implements ApiMethod<ReportNASActionParams, Boolean> {
    public final ApiRequest m6114a(Object obj) {
        ReportNASActionParams reportNASActionParams = (ReportNASActionParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("event", reportNASActionParams.f4157a));
        a.add(new BasicNameValuePair("client_time", Long.toString(reportNASActionParams.f4158b.longValue())));
        a.add(new BasicNameValuePair("log_exposure", Boolean.toString(false)));
        a.add(new BasicNameValuePair("product", "fb4a_composer"));
        a.add(new BasicNameValuePair("is_default_nas", Boolean.toString(reportNASActionParams.f4159c)));
        if (!TextUtils.isEmpty(reportNASActionParams.f4160d)) {
            a.add(new BasicNameValuePair("selected_privacy", reportNASActionParams.f4160d));
        }
        if (!TextUtils.isEmpty(reportNASActionParams.f4161e)) {
            a.add(new BasicNameValuePair("source", reportNASActionParams.f4161e));
        }
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("reportNASAction", "POST", "me/newcomer_audience", a, ApiResponseType.JSON);
    }

    public final Object m6115a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
