package com.facebook.zero.protocol.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.server.FetchZeroHeaderRequestParams;
import com.facebook.zero.server.FetchZeroHeaderRequestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import java.lang.reflect.Type;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: fi */
public class FetchZeroHeaderRequestMethod extends ZeroBaseMethod implements ApiMethod<FetchZeroHeaderRequestParams, FetchZeroHeaderRequestResult> {
    private static final Class<?> f23735a = FetchZeroHeaderRequestMethod.class;
    private final ObjectMapper f23736b;

    public static FetchZeroHeaderRequestMethod m32159b(InjectorLike injectorLike) {
        return new FetchZeroHeaderRequestMethod(FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        List b = m32160b((FetchZeroHeaderRequestParams) obj);
        b.toString();
        return new ApiRequest("fetchZeroHeaderRequest", "GET", "method/mobile.zeroHeaderRequest", b, ApiResponseType.JSON);
    }

    @Inject
    public FetchZeroHeaderRequestMethod(ObjectMapper objectMapper) {
        this.f23736b = objectMapper;
    }

    @VisibleForTesting
    private List<NameValuePair> m32160b(FetchZeroHeaderRequestParams fetchZeroHeaderRequestParams) {
        String str;
        List<NameValuePair> a = ZeroBaseMethod.m32153a(fetchZeroHeaderRequestParams);
        a.add(new BasicNameValuePair("machine_id", fetchZeroHeaderRequestParams.a));
        String str2 = "force_refresh";
        if (fetchZeroHeaderRequestParams.b) {
            str = "true";
        } else {
            str = "false";
        }
        a.add(new BasicNameValuePair(str2, str));
        return a;
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        apiResponse.m22211i();
        return (FetchZeroHeaderRequestResult) this.f23736b.m6648a(apiResponse.m22205c().mo720a(this.f23736b), this.f23736b._typeFactory.m7109a((Type) FetchZeroHeaderRequestResult.class));
    }
}
