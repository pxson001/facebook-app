package com.facebook.privacy.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: static_web_uri */
public final class SetComposerStickyPrivacyMethod implements ApiMethod<SetComposerStickyPrivacyParams, Void> {
    public final ApiRequest m6125a(Object obj) {
        SetComposerStickyPrivacyParams setComposerStickyPrivacyParams = (SetComposerStickyPrivacyParams) obj;
        List a = Lists.a(3);
        a.add(new BasicNameValuePair("privacy", setComposerStickyPrivacyParams.f4189a));
        a.add(new BasicNameValuePair("setting", "COMPOSER"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("setComposerStickyPrivacy", "POST", "me/privacy_setting", a, ApiResponseType.JSON);
    }

    public final Object m6126a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
