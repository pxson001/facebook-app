package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.ZeroOptoutParams;
import com.facebook.zero.sdk.request.ZeroOptoutResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fgl_scan_success */
public class ZeroOptoutMethod extends ZeroBaseMethod implements ApiMethod<ZeroOptoutParams, ZeroOptoutResult> {
    private static final Class<?> f23742a = ZeroOptoutMethod.class;
    private final ObjectMapper f23743b;

    public static ZeroOptoutMethod m32174b(InjectorLike injectorLike) {
        return new ZeroOptoutMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        List a = ZeroBaseMethod.m32153a((ZeroOptoutParams) obj);
        a.toString();
        return new ApiRequest("zeroOptout", "GET", "method/mobile.zeroOptout", a, ApiResponseType.JSON);
    }

    @Inject
    public ZeroOptoutMethod(ObjectMapper objectMapper) {
        this.f23743b = objectMapper;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (ZeroOptoutResult) this.f23743b.m6648a(apiResponse.m22205c().mo722c(), this.f23743b._typeFactory.m7109a((Type) ZeroOptoutResult.class));
    }
}
