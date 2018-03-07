package com.facebook.platform.common.server;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.google.common.base.Preconditions;
import javax.inject.Provider;

/* compiled from: gatekeepes_unchanged */
public abstract class SimplePlatformOperation<PARAMS, RESULT> extends AbstractPlatformOperation {
    public final Provider<SingleMethodRunner> f11317b;
    private final ApiMethod<PARAMS, RESULT> f11318c;

    public SimplePlatformOperation(String str, Provider<SingleMethodRunner> provider, ApiMethod<PARAMS, RESULT> apiMethod) {
        super(str);
        this.f11317b = provider;
        this.f11318c = apiMethod;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Preconditions.checkArgument(this.f11251a.equals(operationParams.b));
        return mo837a(((AbstractSingleMethodRunner) this.f11317b.get()).a(this.f11318c, mo838a(operationParams.c)));
    }

    protected PARAMS mo838a(Bundle bundle) {
        return null;
    }

    protected OperationResult mo837a(RESULT result) {
        return OperationResult.a;
    }
}
