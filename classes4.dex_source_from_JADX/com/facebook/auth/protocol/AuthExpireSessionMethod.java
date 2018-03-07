package com.facebook.auth.protocol;

import com.facebook.http.common.BootstrapRequestName;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: tap_notification_jewel */
public class AuthExpireSessionMethod implements ApiMethod<Params, Void> {
    public static AuthExpireSessionMethod m1545a(InjectorLike injectorLike) {
        return new AuthExpireSessionMethod();
    }

    public final ApiRequest m1546a(Object obj) {
        Params params = (Params) obj;
        List a = Lists.a(1);
        if (params.a != null) {
            a.add(new BasicNameValuePair("reason", params.a));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = BootstrapRequestName.LOGOUT.requestNameString;
        newBuilder = newBuilder;
        newBuilder.c = TigonRequest.POST;
        newBuilder = newBuilder;
        newBuilder.d = "method/auth.expireSession";
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        return apiRequestBuilder.a(RequestPriority.INTERACTIVE).C();
    }

    public final Object m1547a(Object obj, ApiResponse apiResponse) {
        return null;
    }
}
