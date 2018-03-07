package com.facebook.appirater.api;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: cta_lead_gen_error_confirmation_card_click */
public class AppRaterCreateApiMethod implements ApiMethod<AppRaterReport, Void> {
    public final ApiRequest m20535a(Object obj) {
        AppRaterReport appRaterReport = (AppRaterReport) obj;
        List a = Lists.a(6);
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("review_text", appRaterReport.reviewText));
        a.add(new BasicNameValuePair("num_stars", String.valueOf(appRaterReport.starRating)));
        a.add(new BasicNameValuePair("build_num", String.valueOf(appRaterReport.buildNumber)));
        a.add(new BasicNameValuePair("last_event", appRaterReport.lastEvent));
        a.add(new BasicNameValuePair("client_time", String.valueOf(appRaterReport.lastEventCompletedAtMillis / 1000)));
        return new ApiRequest("app_rater_create_report", "POST", "method/app_rater.create", a, ApiResponseType.JSON);
    }

    public final Object m20536a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
