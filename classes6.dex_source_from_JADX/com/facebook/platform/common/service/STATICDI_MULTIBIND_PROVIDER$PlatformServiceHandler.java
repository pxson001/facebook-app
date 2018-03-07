package com.facebook.platform.common.service;

import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.platform.GetInstallDataServiceHandler;
import com.facebook.platform.auth.service.RefreshTokenServiceHandler;
import com.facebook.platform.common.config.DefaultPlatformConfig;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class STATICDI_MULTIBIND_PROVIDER$PlatformServiceHandler implements MultiBindIndexedProvider<PlatformServiceHandler>, Provider<Set<PlatformServiceHandler>> {
    private final InjectorLike f4093a;

    public STATICDI_MULTIBIND_PROVIDER$PlatformServiceHandler(InjectorLike injectorLike) {
        this.f4093a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4093a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return GetInstallDataServiceHandler.a(injector);
            case 1:
                return new RefreshTokenServiceHandler(IdBasedProvider.a(injector, 9625), DefaultBlueServiceOperationFactory.b(injector));
            case 2:
                return new GetLikeStateServiceHandler(IdBasedProvider.a(injector, 9634));
            case 3:
                return new GetProtocolVersionsServiceHandler(IdBasedProvider.a(injector, 9635), DefaultPlatformConfig.m5965a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
