package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import javax.annotation.Nullable;

/* compiled from: requests_still_pending */
public abstract class AbstractSingleMethodRunner {
    protected abstract <PARAMS, RESULT> RESULT mo1648b(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext);

    public final <PARAMS, RESULT> RESULT m11743a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params) {
        return mo1648b(apiMethod, params, null, null);
    }

    public final <PARAMS, RESULT> RESULT m11744a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, CallerContext callerContext) {
        return mo1648b(apiMethod, params, null, callerContext);
    }

    public final <PARAMS, RESULT> RESULT m11745a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams) {
        return mo1648b(apiMethod, params, apiMethodRunnerParams, null);
    }

    public final <PARAMS, RESULT> RESULT m11746a(ApiMethod<PARAMS, RESULT> apiMethod, @Nullable PARAMS params, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, @Nullable CallerContext callerContext) {
        return mo1648b(apiMethod, params, apiMethodRunnerParams, callerContext);
    }
}
