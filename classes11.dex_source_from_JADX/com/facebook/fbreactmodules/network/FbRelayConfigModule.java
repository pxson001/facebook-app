package com.facebook.fbreactmodules.network;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: edges is empty */
public class FbRelayConfigModule extends BaseJavaModule {
    private final Lazy<ViewerContext> f7508a;
    private final Provider<PlatformAppHttpConfig> f7509b;

    public static FbRelayConfigModule m8712b(InjectorLike injectorLike) {
        return new FbRelayConfigModule(IdBasedLazy.a(injectorLike, 372), IdBasedProvider.a(injectorLike, 2243));
    }

    @Inject
    public FbRelayConfigModule(Lazy<ViewerContext> lazy, Provider<PlatformAppHttpConfig> provider) {
        this.f7508a = lazy;
        this.f7509b = provider;
    }

    public String getName() {
        return "RelayAPIConfig";
    }

    public final Map<String, Object> m8713a() {
        Map hashMap = new HashMap();
        ViewerContext viewerContext = (ViewerContext) this.f7508a.get();
        Preconditions.checkNotNull(viewerContext);
        hashMap.put("accessToken", viewerContext.mAuthToken);
        hashMap.put("actorID", viewerContext.mUserId);
        hashMap.put("fetchTimeout", Integer.valueOf(15000));
        hashMap.put("retryDelays", Collections.emptyList());
        hashMap.put("xhrEncoding", "gzip");
        PlatformAppHttpConfig platformAppHttpConfig = (PlatformAppHttpConfig) this.f7509b.get();
        hashMap.put("graphBatchURI", platformAppHttpConfig.b().appendEncodedPath("graphqlbatch").build().toString());
        hashMap.put("graphURI", platformAppHttpConfig.b().appendEncodedPath("graphql").build().toString());
        hashMap.put("graphURIPrefix", platformAppHttpConfig.b().build().toString());
        return hashMap;
    }

    public static FbRelayConfigModule m8711a(InjectorLike injectorLike) {
        return m8712b(injectorLike);
    }
}
