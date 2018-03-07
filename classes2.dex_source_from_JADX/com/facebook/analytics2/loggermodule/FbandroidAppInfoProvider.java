package com.facebook.analytics2.loggermodule;

import com.facebook.config.application.PlatformAppConfig;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: task_key_toggle_page_like */
public class FbandroidAppInfoProvider {
    private final Lazy<PlatformAppConfig> f3158a;
    private final Lazy<AppVersionInfo> f3159b;

    public static FbandroidAppInfoProvider m5317b(InjectorLike injectorLike) {
        return new FbandroidAppInfoProvider(injectorLike.getLazy(PlatformAppConfig.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 879));
    }

    @Inject
    public FbandroidAppInfoProvider(Lazy<PlatformAppConfig> lazy, Lazy<AppVersionInfo> lazy2) {
        this.f3158a = lazy;
        this.f3159b = lazy2;
    }

    public final String m5318a() {
        return ((PlatformAppConfig) this.f3158a.get()).c();
    }

    public final String m5319b() {
        return ((AppVersionInfo) this.f3159b.get()).mo367a();
    }

    public final int m5320c() {
        return ((AppVersionInfo) this.f3159b.get()).mo368b();
    }
}
