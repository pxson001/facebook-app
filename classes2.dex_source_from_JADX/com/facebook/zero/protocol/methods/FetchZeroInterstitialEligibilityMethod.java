package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityParams;
import com.facebook.zero.sdk.request.FetchZeroInterstitialEligibilityResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;

/* compiled from: fgl_scan_start */
public class FetchZeroInterstitialEligibilityMethod extends ZeroBaseMethod implements ApiMethod<FetchZeroInterstitialEligibilityParams, FetchZeroInterstitialEligibilityResult> {
    private static final Class<?> f23744a = FetchZeroInterstitialEligibilityMethod.class;
    private final ObjectMapper f23745b;

    public static FetchZeroInterstitialEligibilityMethod m32177b(InjectorLike injectorLike) {
        return new FetchZeroInterstitialEligibilityMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        List a = ZeroBaseMethod.m32153a((FetchZeroInterstitialEligibilityParams) obj);
        a.toString();
        return new ApiRequest("fetchZeroInterstitialEligibility", "GET", "method/mobile.zeroInterstitialEligibility", a, ApiResponseType.JSON);
    }

    @Inject
    public FetchZeroInterstitialEligibilityMethod(ObjectMapper objectMapper) {
        this.f23745b = objectMapper;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (FetchZeroInterstitialEligibilityResult) this.f23745b.m6648a(apiResponse.m22205c().mo720a(this.f23745b), this.f23745b._typeFactory.m7109a((Type) FetchZeroInterstitialEligibilityResult.class));
    }
}
