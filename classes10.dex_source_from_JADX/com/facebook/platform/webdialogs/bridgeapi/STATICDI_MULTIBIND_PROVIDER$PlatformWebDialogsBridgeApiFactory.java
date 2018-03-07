package com.facebook.platform.webdialogs.bridgeapi;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class STATICDI_MULTIBIND_PROVIDER$PlatformWebDialogsBridgeApiFactory implements MultiBindIndexedProvider<PlatformWebDialogsBridgeApiFactory>, Provider<Set<PlatformWebDialogsBridgeApiFactory>> {
    private final InjectorLike f8548a;

    public STATICDI_MULTIBIND_PROVIDER$PlatformWebDialogsBridgeApiFactory(InjectorLike injectorLike) {
        this.f8548a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8548a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PlatformWebDialogsCloseBridgeApiFactory.m8445a((InjectorLike) injector);
            case 1:
                return PlatformWebDialogsDialogIsInteractiveBridgeApiFactory.m8451a((InjectorLike) injector);
            case 2:
                return PlatformWebDialogsDialogReadyBridgeApiFactory.m8456a((InjectorLike) injector);
            case 3:
                return PlatformWebDialogsOpenDialogBridgeApiFactory.m8461a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
