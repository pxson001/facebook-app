package com.facebook.zero.protocol.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.server.ZeroUpdateStatusParams;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fgl_app_foreground */
public class ZeroUpdateStatusMethod extends ZeroBaseMethod implements ApiMethod<ZeroUpdateStatusParams, ApiResponse> {
    private static final Class<?> f23748a = ZeroUpdateStatusMethod.class;

    public static ZeroUpdateStatusMethod m32183a(InjectorLike injectorLike) {
        return new ZeroUpdateStatusMethod();
    }

    public final ApiRequest mo672a(Object obj) {
        List b = m32184b((ZeroUpdateStatusParams) obj);
        b.toString();
        return new ApiRequest("zeroUpdateStatus", "GET", "method/mobile.zeroUpdateStatus", b, ApiResponseType.JSON);
    }

    @VisibleForTesting
    private List<NameValuePair> m32184b(ZeroUpdateStatusParams zeroUpdateStatusParams) {
        List<NameValuePair> a = ZeroBaseMethod.m32153a(zeroUpdateStatusParams);
        a.add(new BasicNameValuePair("status_to_update", zeroUpdateStatusParams.a));
        return a;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        return apiResponse;
    }
}
