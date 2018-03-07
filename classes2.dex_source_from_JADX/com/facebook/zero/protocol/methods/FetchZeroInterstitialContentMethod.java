package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fgl_scan_fail */
public class FetchZeroInterstitialContentMethod extends ZeroBaseMethod implements ApiMethod<FetchZeroInterstitialContentParams, FetchZeroInterstitialContentResult> {
    private static final Class<?> f23746a = FetchZeroInterstitialContentMethod.class;
    private final ObjectMapper f23747b;

    public static FetchZeroInterstitialContentMethod m32180b(InjectorLike injectorLike) {
        return new FetchZeroInterstitialContentMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        FetchZeroInterstitialContentParams fetchZeroInterstitialContentParams = (FetchZeroInterstitialContentParams) obj;
        List a = ZeroBaseMethod.m32153a(fetchZeroInterstitialContentParams);
        a.add(new BasicNameValuePair("screen_scale", fetchZeroInterstitialContentParams.a));
        a.add(new BasicNameValuePair("step", fetchZeroInterstitialContentParams.b));
        a.add(new BasicNameValuePair("action", fetchZeroInterstitialContentParams.c));
        a.toString();
        return new ApiRequest("zeroInterstitialContent", "GET", "method/mobile.zeroInterstitialContent", a, ApiResponseType.JSON);
    }

    @Inject
    public FetchZeroInterstitialContentMethod(ObjectMapper objectMapper) {
        this.f23747b = objectMapper;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (FetchZeroInterstitialContentResult) this.f23747b.m6648a(apiResponse.m22205c().mo720a(this.f23747b), this.f23747b._typeFactory.m7109a((Type) FetchZeroInterstitialContentResult.class));
    }
}
