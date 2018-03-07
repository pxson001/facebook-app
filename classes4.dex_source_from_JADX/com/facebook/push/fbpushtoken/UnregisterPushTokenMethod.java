package com.facebook.push.fbpushtoken;

import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: incoming_hot_like_small_message */
public class UnregisterPushTokenMethod implements ApiMethod<UnregisterPushTokenParams, Boolean> {
    public static UnregisterPushTokenMethod m10894a(InjectorLike injectorLike) {
        return new UnregisterPushTokenMethod();
    }

    public final ApiRequest m10895a(Object obj) {
        UnregisterPushTokenParams unregisterPushTokenParams = (UnregisterPushTokenParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        a.add(new BasicNameValuePair("token", unregisterPushTokenParams.a));
        return new ApiRequest(BootstrapRequestName.UNREGISTER_PUSH.requestNameString, TigonRequest.POST, "method/user.unregisterPushCallback", a, ApiResponseType.STRING);
    }

    public final Object m10896a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf("true".equals(apiResponse.b()));
    }
}
