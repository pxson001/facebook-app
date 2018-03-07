package com.facebook.loom.module;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.core.BackgroundUploadService;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: time_since_last_photo_uploaded */
public class LoomBridge {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<BackgroundUploadService> f2823a = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LoomConfigProvider> f2824b = UltralightRuntime.f368b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LoomBridgeListener> f2825c = UltralightRuntime.f368b;

    public static LoomBridge m4827b(InjectorLike injectorLike) {
        LoomBridge loomBridge = new LoomBridge();
        com.facebook.inject.Lazy a = IdBasedLazy.m1808a(injectorLike, 2506);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.m1810b(injectorLike, 2512);
        com.facebook.inject.Lazy a2 = IdBasedLazy.m1808a(injectorLike, 7472);
        loomBridge.f2823a = a;
        loomBridge.f2824b = b;
        loomBridge.f2825c = a2;
        return loomBridge;
    }
}
