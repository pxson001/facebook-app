package com.facebook.privacy.protocol;

import android.text.TextUtils;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sticker_download_manager */
public class ReportInlinePrivacySurveyActionMethod implements ApiMethod<ReportInlinePrivacySurveyActionParams, Boolean> {
    public final ApiRequest m6112a(Object obj) {
        ReportInlinePrivacySurveyActionParams reportInlinePrivacySurveyActionParams = (ReportInlinePrivacySurveyActionParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("event", reportInlinePrivacySurveyActionParams.f4152a));
        a.add(new BasicNameValuePair("client_time", Long.toString(reportInlinePrivacySurveyActionParams.f4153b)));
        if (!TextUtils.isEmpty(reportInlinePrivacySurveyActionParams.f4154c)) {
            a.add(new BasicNameValuePair("from_privacy", reportInlinePrivacySurveyActionParams.f4154c));
        }
        if (!TextUtils.isEmpty(reportInlinePrivacySurveyActionParams.f4155d)) {
            a.add(new BasicNameValuePair("to_privacy", reportInlinePrivacySurveyActionParams.f4155d));
        }
        a.add(new BasicNameValuePair("product", "fb4a_composer"));
        if (!TextUtils.isEmpty(reportInlinePrivacySurveyActionParams.f4156e)) {
            a.add(new BasicNameValuePair("source", reportInlinePrivacySurveyActionParams.f4156e));
        }
        return new ApiRequest("reportInlinePrivacySurveyAction", "POST", "me/inline_privacy_survey_events", RequestPriority.CAN_WAIT, a, ApiResponseType.JSON);
    }

    public final Object m6113a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
