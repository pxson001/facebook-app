package com.facebook.push.fbpushtoken;

import com.facebook.common.time.Clock;
import com.facebook.common.util.JSONUtil;
import com.facebook.config.application.FbAppType;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: i2o_ul_bwe */
public class RegisterPushTokenNoUserMethod implements ApiMethod<RegisterPushTokenNoUserParams, RegisterPushTokenResult> {
    private Clock f10558a;
    private FbAppType f10559b;

    public final ApiRequest m11095a(Object obj) {
        RegisterPushTokenNoUserParams registerPushTokenNoUserParams = (RegisterPushTokenNoUserParams) obj;
        ImmutableList of = ImmutableList.of(new BasicNameValuePair("push_url", registerPushTokenNoUserParams.a), new BasicNameValuePair("token", registerPushTokenNoUserParams.b), new BasicNameValuePair("access_token", registerPushTokenNoUserParams.c), new BasicNameValuePair("locale", Locale.US.toString()), new BasicNameValuePair("device_id", registerPushTokenNoUserParams.d));
        String str = this.f10559b.c() + "/nonuserpushtokens";
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "registerPushNoUser";
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = str;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.g = of;
        ApiRequestBuilder a = apiRequestBuilder.a(RequestPriority.NON_INTERACTIVE);
        a.k = ApiResponseType.JSON;
        return a.C();
    }

    @Inject
    public RegisterPushTokenNoUserMethod(Clock clock, FbAppType fbAppType) {
        this.f10558a = clock;
        this.f10559b = fbAppType;
    }

    public final Object m11096a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return new RegisterPushTokenResult(JSONUtil.g(apiResponse.c().b("success")), false, this.f10558a.a());
    }
}
