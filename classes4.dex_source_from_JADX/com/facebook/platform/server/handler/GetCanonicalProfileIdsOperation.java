package com.facebook.platform.server.handler;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.server.SimplePlatformOperation;
import com.facebook.platform.server.protocol.GetCanonicalProfileIdsMethod;
import com.facebook.platform.server.protocol.GetCanonicalProfileIdsMethod.Params;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: full_quality_photos */
public class GetCanonicalProfileIdsOperation extends SimplePlatformOperation<Params, HashMap<String, ParcelableString>> {
    public static GetCanonicalProfileIdsOperation m11766b(InjectorLike injectorLike) {
        return new GetCanonicalProfileIdsOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new GetCanonicalProfileIdsMethod());
    }

    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((HashMap) obj);
    }

    @Inject
    public GetCanonicalProfileIdsOperation(Provider<SingleMethodRunner> provider, GetCanonicalProfileIdsMethod getCanonicalProfileIdsMethod) {
        super("platform_get_canonical_profile_ids", provider, getCanonicalProfileIdsMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("app_scoped_ids");
    }
}
