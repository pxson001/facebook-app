package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.appdiscovery.lite.abtest.AutoQESpecForLiteAbTestModule;
import com.facebook.apptab.state.abtest.NavImmersiveExperimentSpecificationHolder;
import com.facebook.apptab.state.abtest.NavMemoryExperimentSpecificationHolder;
import com.facebook.feedplugins.musicpreview.MusicPreviewQuickExperimentSpecificationHolder;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.instantshopping.abtest.AutoQESpecForInstantShoppingAbtestModule;
import com.facebook.sideloading.AutoQESpecForSideloadingModule;
import com.facebook.stickers.abtest.StickersQeSpecificationHolder;
import com.facebook.ufiservices.qe.UfiServicesQuickExperimentSpecificationHolder;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$QuickExperimentSpecificationHolder implements MultiBindIndexedProvider<QuickExperimentSpecificationHolder>, Provider<Set<QuickExperimentSpecificationHolder>> {
    private final InjectorLike f9557a;

    public STATICDI_MULTIBIND_PROVIDER$QuickExperimentSpecificationHolder(InjectorLike injectorLike) {
        this.f9557a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9557a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 8;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AutoQESpecForLiteAbTestModule.m9947a(injector);
            case 1:
                return new NavImmersiveExperimentSpecificationHolder();
            case 2:
                return new NavMemoryExperimentSpecificationHolder();
            case 3:
                return new MusicPreviewQuickExperimentSpecificationHolder();
            case 4:
                return AutoQESpecForInstantShoppingAbtestModule.m9969a(injector);
            case 5:
                return AutoQESpecForSideloadingModule.m9981a(injector);
            case 6:
                return new StickersQeSpecificationHolder();
            case 7:
                return new UfiServicesQuickExperimentSpecificationHolder();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
