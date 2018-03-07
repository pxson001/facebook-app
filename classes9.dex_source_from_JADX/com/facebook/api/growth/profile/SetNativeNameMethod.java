package com.facebook.api.growth.profile;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sendMessageToPendingThreadParams */
public class SetNativeNameMethod implements ApiMethod<SetNativeNameParams, String> {
    public final ApiRequest m3926a(Object obj) {
        SetNativeNameParams setNativeNameParams = (SetNativeNameParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("first_name", setNativeNameParams.f4043a));
        a.add(new BasicNameValuePair("last_name", setNativeNameParams.f4044b));
        String str = setNativeNameParams.f4045c;
        if (str != null) {
            a.add(new BasicNameValuePair("first_name_extra", str));
        }
        str = setNativeNameParams.f4046d;
        if (str != null) {
            a.add(new BasicNameValuePair("last_name_extra", str));
        }
        a.add(new BasicNameValuePair("locale", setNativeNameParams.f4047e));
        return new ApiRequest("SetNativeName", "POST", "method/user.setNativeName", a, ApiResponseType.JSON);
    }

    public final Object m3927a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
