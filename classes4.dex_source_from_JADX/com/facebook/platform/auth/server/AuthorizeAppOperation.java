package com.facebook.platform.auth.server;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.auth.server.AuthorizeAppMethod.Params;
import com.facebook.platform.auth.server.AuthorizeAppMethod.Result;
import com.facebook.platform.common.server.SimplePlatformOperation;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: gc_freed_count */
public class AuthorizeAppOperation extends SimplePlatformOperation<Params, Result> {
    public static AuthorizeAppOperation m11738b(InjectorLike injectorLike) {
        return new AuthorizeAppOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new AuthorizeAppMethod());
    }

    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((Result) obj);
    }

    @Inject
    public AuthorizeAppOperation(Provider<SingleMethodRunner> provider, AuthorizeAppMethod authorizeAppMethod) {
        super("platform_authorize_app", provider, authorizeAppMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("app_info");
    }
}
