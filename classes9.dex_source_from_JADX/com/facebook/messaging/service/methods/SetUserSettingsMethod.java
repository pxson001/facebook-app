package com.facebook.messaging.service.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.messaging.service.model.SetSettingsParams;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: credit_card */
public class SetUserSettingsMethod implements ApiMethod<SetSettingsParams, Void> {
    public final ApiRequest m17056a(Object obj) {
        SetSettingsParams setSettingsParams = (SetSettingsParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        if (setSettingsParams.f17327a) {
            a.add(new BasicNameValuePair("mute_until", Long.toString(setSettingsParams.f17328b.a())));
        }
        return new ApiRequest("setUserSettings", "POST", "method/messaging.setsettings", a, ApiResponseType.STRING);
    }

    public final Object m17057a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
