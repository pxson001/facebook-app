package com.facebook.platform.server.handler;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.platform.common.server.SimplePlatformOperation;
import com.facebook.platform.server.protocol.GetAppNameMethod;
import com.facebook.platform.server.protocol.GetAppNameMethod.Params;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: full_upload */
public class GetAppNameOperation extends SimplePlatformOperation<Params, String> {
    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((String) obj);
    }

    @Inject
    public GetAppNameOperation(Provider<SingleMethodRunner> provider, GetAppNameMethod getAppNameMethod) {
        super("platform_get_app_name", provider, getAppNameMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("app_name");
    }
}
