package com.facebook.fbservice.service;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.http.common.FbRequestState;

/* compiled from: response_action */
public class OperationParams$Builder {
    public String f3055a;
    public String f3056b;
    public Bundle f3057c;
    public FbRequestState f3058d;
    public CallerContext f3059e;
    public BlueServiceProgressCallback f3060f;

    public final OperationParams$Builder m4213a(OperationParams operationParams) {
        this.f3055a = operationParams.a;
        this.f3056b = operationParams.b;
        this.f3057c = operationParams.c;
        this.f3058d = operationParams.d;
        this.f3059e = operationParams.e;
        this.f3060f = operationParams.f;
        return this;
    }

    public final OperationParams m4214g() {
        return new OperationParams(this);
    }
}
