package com.facebook.languages.switcher.service;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: time_on_screen_millis */
public class GetUserLocaleMethod implements ApiMethod<String, String> {
    public static GetUserLocaleMethod m1420a(InjectorLike injectorLike) {
        return new GetUserLocaleMethod();
    }

    public final ApiRequest m1421a(Object obj) {
        String str = (String) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("fields", "locale"));
        return new ApiRequest("userLocale", "GET", str, a, ApiResponseType.JSON);
    }

    public final Object m1422a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("locale").B();
    }
}
