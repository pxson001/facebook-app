package com.facebook.privacy.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: staticWebUri */
public final class SetPrivacyEducationStateMethod implements ApiMethod<SetPrivacyEducationStateParams, Boolean> {
    public final ApiRequest m6127a(Object obj) {
        SetPrivacyEducationStateParams setPrivacyEducationStateParams = (SetPrivacyEducationStateParams) obj;
        List a = Lists.a(5);
        a.add(new BasicNameValuePair("education_type", setPrivacyEducationStateParams.f4190a));
        a.add(new BasicNameValuePair("event", setPrivacyEducationStateParams.f4191b));
        a.add(new BasicNameValuePair("surface", setPrivacyEducationStateParams.f4192c));
        a.add(new BasicNameValuePair("client_time", Long.toString(setPrivacyEducationStateParams.f4193d.longValue())));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("setPrivacyEducationState", "POST", "me/privacy_education", a, ApiResponseType.JSON);
    }

    public final Object m6128a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
