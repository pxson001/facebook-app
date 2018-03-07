package com.facebook.crudolib.net;

import com.facebook.crudolib.netengine.fbhttp.FbHttpEngineResponse;
import javax.annotation.Nullable;

/* compiled from: TodayMixedRecyclerViewAdapter IndexOutOfBoundsException */
public class CompositeResponseInterceptor implements ResponseInterceptor {
    private final ResponseInterceptor[] f24025a;

    @Nullable
    public static ResponseInterceptor m25967a(@Nullable ResponseInterceptor responseInterceptor, @Nullable ResponseInterceptor responseInterceptor2) {
        if (responseInterceptor == null) {
            return responseInterceptor2;
        }
        if (responseInterceptor2 == null) {
            return responseInterceptor;
        }
        return new CompositeResponseInterceptor(new ResponseInterceptor[]{responseInterceptor, responseInterceptor2});
    }

    private CompositeResponseInterceptor(ResponseInterceptor[] responseInterceptorArr) {
        this.f24025a = responseInterceptorArr;
    }

    public final void mo1107a(AppRequest appRequest, FbHttpEngineResponse fbHttpEngineResponse) {
        for (ResponseInterceptor a : this.f24025a) {
            a.mo1107a(appRequest, fbHttpEngineResponse);
        }
    }
}
