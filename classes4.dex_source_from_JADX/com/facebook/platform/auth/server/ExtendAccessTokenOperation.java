package com.facebook.platform.auth.server;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.auth.server.ExtendAccessTokenMethod.Params;
import com.facebook.platform.auth.server.ExtendAccessTokenMethod.Result;
import com.facebook.platform.common.server.SimplePlatformOperation;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: game_rotation_vector */
public class ExtendAccessTokenOperation extends SimplePlatformOperation<Params, Result> {
    public static ExtendAccessTokenOperation m11746b(InjectorLike injectorLike) {
        return new ExtendAccessTokenOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new ExtendAccessTokenMethod());
    }

    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((Result) obj);
    }

    @Inject
    public ExtendAccessTokenOperation(Provider<SingleMethodRunner> provider, ExtendAccessTokenMethod extendAccessTokenMethod) {
        super("platform_extend_access_token", provider, extendAccessTokenMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("access_token");
    }
}
