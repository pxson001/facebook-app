package com.facebook.placetips.bootstrap;

import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.placetips.gpscore.PlaceTipsGpsDebugStatusProvider;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.pulsarcore.PlaceTipsBleDebugStatusProvider;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs.Accessor;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$PlaceTipsDebugStatusDataProvider implements MultiBindIndexedProvider<PlaceTipsDebugStatusDataProvider>, Provider<Set<PlaceTipsDebugStatusDataProvider>> {
    private final InjectorLike f3825a;

    public STATICDI_MULTIBIND_PROVIDER$PlaceTipsDebugStatusDataProvider(InjectorLike injectorLike) {
        this.f3825a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3825a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new PlaceTipsGpsDebugStatusProvider((QeAccessor) QeInternalImplMethodAutoProvider.a(injector));
            case 1:
                return PlaceTipsLocalLoggerImpl.a(injector);
            case 2:
                return new PlaceTipsBleDebugStatusProvider(IdBasedSingletonScopeProvider.b(injector, 2483), IdBasedLazy.a(injector, 3018), IdBasedProvider.a(injector, 10));
            case 3:
                return Accessor.b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
