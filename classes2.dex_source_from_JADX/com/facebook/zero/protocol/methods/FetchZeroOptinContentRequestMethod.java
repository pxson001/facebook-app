package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestParams;
import com.facebook.zero.sdk.request.FetchZeroOptinContentRequestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fgl_write_success */
public class FetchZeroOptinContentRequestMethod extends ZeroBaseMethod implements ApiMethod<FetchZeroOptinContentRequestParams, FetchZeroOptinContentRequestResult> {
    private static final Class<?> f23737a = FetchZeroOptinContentRequestMethod.class;
    private final ObjectMapper f23738b;

    public static FetchZeroOptinContentRequestMethod m32163b(InjectorLike injectorLike) {
        return new FetchZeroOptinContentRequestMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        FetchZeroOptinContentRequestParams fetchZeroOptinContentRequestParams = (FetchZeroOptinContentRequestParams) obj;
        List a = ZeroBaseMethod.m32153a(fetchZeroOptinContentRequestParams);
        a.add(new BasicNameValuePair("screen_scale", fetchZeroOptinContentRequestParams.a));
        a.toString();
        return new ApiRequest("zeroGetOptinContent", "GET", "method/mobile.zeroGetOptinContent", a, ApiResponseType.JSON);
    }

    @Inject
    public FetchZeroOptinContentRequestMethod(ObjectMapper objectMapper) {
        this.f23738b = objectMapper;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (FetchZeroOptinContentRequestResult) this.f23738b.m6648a(apiResponse.m22205c().mo720a(this.f23738b), this.f23738b._typeFactory.m7109a((Type) FetchZeroOptinContentRequestResult.class));
    }
}
