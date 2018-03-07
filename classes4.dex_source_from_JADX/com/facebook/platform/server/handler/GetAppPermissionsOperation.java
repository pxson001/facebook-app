package com.facebook.platform.server.handler;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.server.SimplePlatformOperation;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod.Params;
import com.facebook.platform.server.protocol.GetAppPermissionsMethod.Result;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: full_screen_count */
public class GetAppPermissionsOperation extends SimplePlatformOperation<Params, Result> {
    public static GetAppPermissionsOperation m11761b(InjectorLike injectorLike) {
        return new GetAppPermissionsOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new GetAppPermissionsMethod());
    }

    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((Result) obj);
    }

    @Inject
    public GetAppPermissionsOperation(Provider<SingleMethodRunner> provider, GetAppPermissionsMethod getAppPermissionsMethod) {
        super("platform_get_app_permissions", provider, getAppPermissionsMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("app_info");
    }
}
