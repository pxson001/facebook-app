package com.facebook.platform.server.handler;

import android.os.Bundle;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.server.SimplePlatformOperation;
import com.facebook.platform.server.protocol.ResolveTaggableProfileIdsMethod;
import com.facebook.platform.server.protocol.ResolveTaggableProfileIdsMethod.Params;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fullQualityImageUpload */
public class ResolveTaggableProfileIdsOperation extends SimplePlatformOperation<Params, HashMap<String, ParcelableString>> {
    public static ResolveTaggableProfileIdsOperation m11771b(InjectorLike injectorLike) {
        return new ResolveTaggableProfileIdsOperation(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new ResolveTaggableProfileIdsMethod());
    }

    protected final OperationResult mo837a(Object obj) {
        return OperationResult.a((HashMap) obj);
    }

    @Inject
    public ResolveTaggableProfileIdsOperation(Provider<SingleMethodRunner> provider, ResolveTaggableProfileIdsMethod resolveTaggableProfileIdsMethod) {
        super("platform_resolve_taggable_profile_ids", provider, resolveTaggableProfileIdsMethod);
    }

    protected final Object mo838a(Bundle bundle) {
        return (Params) bundle.getParcelable("taggable_ids");
    }
}
