package com.facebook.contactlogs.protocol;

import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: profile_nux_refresher_model */
public class SetContactLogsUploadSettingMethod implements ApiMethod<Setting, Void> {

    /* compiled from: profile_nux_refresher_model */
    public enum Setting {
        UNKNOWN,
        ON,
        OFF
    }

    public final ApiRequest m6507a(Object obj) {
        Setting setting = (Setting) obj;
        List a = Lists.a(new NameValuePair[]{new BasicNameValuePair("format", "json"), new BasicNameValuePair("setting", setting.name())});
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "FriendFinderCallLogSettingPost";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/FriendFinderCallLogSettingPost";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder a2 = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a2.k = ApiResponseType.JSON;
        return a2.C();
    }

    public final Object m6508a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
