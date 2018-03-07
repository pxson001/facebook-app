package com.facebook.growth.protocol;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: p2p_platform_banner_dismissal */
public class SetContinuousContactsUploadMethod implements ApiMethod<Setting, Void> {
    private final UniqueIdForDeviceHolderImpl f7523a;

    /* compiled from: p2p_platform_banner_dismissal */
    public enum Setting {
        UNKNOWN,
        ON,
        OFF
    }

    public final ApiRequest m7822a(Object obj) {
        Setting setting = (Setting) obj;
        List a = Lists.a(new NameValuePair[]{new BasicNameValuePair("format", "json"), new BasicNameValuePair("setting", setting.name()), new BasicNameValuePair("phone_id", this.f7523a.a())});
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "FriendFinderContinuousSyncSettingPost";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "method/FriendFinderContinuousSyncSettingPost";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder a2 = newBuilder.a(RequestPriority.NON_INTERACTIVE);
        a2.k = ApiResponseType.JSON;
        return a2.C();
    }

    @Inject
    public SetContinuousContactsUploadMethod(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f7523a = uniqueIdForDeviceHolderImpl;
    }

    public final Object m7823a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return null;
    }
}
