package com.facebook.http.protocol;

import com.facebook.common.callercontext.CallerContext;
import javax.annotation.Nullable;

/* compiled from: feature_tag */
public interface ApiMethodRunner$Batch {

    /* compiled from: feature_tag */
    public enum Type {
        NORMAL,
        STREAMING
    }

    ApiMethodRunner$Batch mo885a(Type type);

    ApiMethodRunner$Batch mo886a(DeviceApiContext deviceApiContext);

    <RESULT> RESULT mo887a(String str);

    <PARAMS, RESULT> void mo888a(BatchOperation<PARAMS, RESULT> batchOperation);

    void mo889a(String str, CallerContext callerContext);

    void mo884a(String str, CallerContext callerContext, @Nullable ApiMethodRunnerParams apiMethodRunnerParams);

    @Nullable
    Exception mo890b(String str);

    DeviceApiResult mo891e();
}
