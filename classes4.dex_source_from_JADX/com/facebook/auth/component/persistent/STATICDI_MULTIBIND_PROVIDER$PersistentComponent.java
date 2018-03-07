package com.facebook.auth.component.persistent;

import com.facebook.abtest.qe.login.QePersistentComponent;
import com.facebook.abtest.qe.service.QuickExperimentDataMaintenanceHelper;
import com.facebook.auth.login.LoggedInUserPersistentComponent;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.internal.GkConfigurationComponent;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.interstitial.configuration.InterstitialConfigurationComponent;
import com.facebook.katana.urimap.fetchable.FacewebUriComponent;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.xconfig.sync.XSyncComponent;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$PersistentComponent implements MultiBindIndexedProvider<PersistentComponent>, Provider<Set<PersistentComponent>> {
    private final InjectorLike f1299a;

    public STATICDI_MULTIBIND_PROVIDER$PersistentComponent(InjectorLike injectorLike) {
        this.f1299a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1299a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<PersistentComponent>> m1528a(InjectorLike injectorLike) {
        return ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$PersistentComponent(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new QePersistentComponent(QuickExperimentDataMaintenanceHelper.m1355b((InjectorLike) injector), IdBasedProvider.a(injector, 4442), (QeManager) QeInternalImplMethodAutoProvider.a(injector));
            case 1:
                return new LoggedInUserPersistentComponent(IdBasedSingletonScopeProvider.b(injector, 339), IdBasedLazy.a(injector, 365), IdBasedLazy.a(injector, 4900), ProductMethodAutoProvider.b(injector));
            case 2:
                return GkConfigurationComponent.m1759a(injector);
            case 3:
                return InterstitialConfigurationComponent.m1771b(injector);
            case 4:
                return FacewebUriComponent.m1780b(injector);
            case 5:
                return XSyncComponent.m1854b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
