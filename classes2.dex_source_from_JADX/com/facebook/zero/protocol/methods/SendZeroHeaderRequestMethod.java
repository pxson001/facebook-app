package com.facebook.zero.protocol.methods;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.server.SendZeroHeaderRequestParams;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fgl_write_start */
public class SendZeroHeaderRequestMethod implements ApiMethod<SendZeroHeaderRequestParams, Void> {
    private static final Class<?> f23739a = SendZeroHeaderRequestMethod.class;

    public static SendZeroHeaderRequestMethod m32166a(InjectorLike injectorLike) {
        return new SendZeroHeaderRequestMethod();
    }

    public final ApiRequest mo672a(Object obj) {
        List b = m32167b((SendZeroHeaderRequestParams) obj);
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.f7526b = "sendZeroHeaderRequest";
        newBuilder = newBuilder;
        newBuilder.f7527c = "GET";
        newBuilder = newBuilder;
        newBuilder.f7528d = "hr/r";
        newBuilder = newBuilder;
        newBuilder.f7541q = true;
        newBuilder = newBuilder;
        newBuilder.f7531g = b;
        newBuilder = newBuilder;
        newBuilder.f7535k = ApiResponseType.STRING;
        newBuilder = newBuilder;
        b.toString();
        return newBuilder.m12125C();
    }

    @VisibleForTesting
    private static List<NameValuePair> m32167b(SendZeroHeaderRequestParams sendZeroHeaderRequestParams) {
        List<NameValuePair> a = Lists.m1296a();
        a.add(new BasicNameValuePair("redirect_app", sendZeroHeaderRequestParams.c));
        a.add(new BasicNameValuePair("n", sendZeroHeaderRequestParams.b));
        a.add(new BasicNameValuePair("zc", sendZeroHeaderRequestParams.a));
        a.add(new BasicNameValuePair("em", sendZeroHeaderRequestParams.d));
        return a;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22204b();
        apiResponse.m22211i();
        return null;
    }
}
