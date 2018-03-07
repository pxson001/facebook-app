package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.ZeroOptinParams;
import com.facebook.zero.sdk.request.ZeroOptinResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fgl_write_fail */
public class ZeroOptinMethod extends ZeroBaseMethod implements ApiMethod<ZeroOptinParams, ZeroOptinResult> {
    private static final Class<?> f23740a = ZeroOptinMethod.class;
    private final ObjectMapper f23741b;

    public static ZeroOptinMethod m32170b(InjectorLike injectorLike) {
        return new ZeroOptinMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        List b = m32171b((ZeroOptinParams) obj);
        b.toString();
        return new ApiRequest("zeroOptin", "GET", "method/mobile.zeroOptin", b, ApiResponseType.JSON);
    }

    @Inject
    public ZeroOptinMethod(ObjectMapper objectMapper) {
        this.f23741b = objectMapper;
    }

    @VisibleForTesting
    private List<NameValuePair> m32171b(ZeroOptinParams zeroOptinParams) {
        List<NameValuePair> a = ZeroBaseMethod.m32153a(zeroOptinParams);
        a.add(new BasicNameValuePair("enc_phone", zeroOptinParams.a));
        return a;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (ZeroOptinResult) this.f23741b.m6648a(apiResponse.m22205c().mo722c(), this.f23741b._typeFactory.m7109a((Type) ZeroOptinResult.class));
    }
}
