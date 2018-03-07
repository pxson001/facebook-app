package com.facebook.config.background;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.orca.background.FetchPinnedThreadsSyncComponent;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$BlueServiceOperationSyncComponent implements MultiBindIndexedProvider<BlueServiceOperationSyncComponent>, Provider<Set<BlueServiceOperationSyncComponent>> {
    private final InjectorLike f3260a;

    public STATICDI_MULTIBIND_PROVIDER$BlueServiceOperationSyncComponent(InjectorLike injectorLike) {
        this.f3260a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3260a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FetchPinnedThreadsSyncComponent.m10737a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
