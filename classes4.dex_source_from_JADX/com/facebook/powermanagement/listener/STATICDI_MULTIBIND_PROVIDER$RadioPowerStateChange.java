package com.facebook.powermanagement.listener;

import com.facebook.backgroundtasks.RadioBasedBackgroundTaskRunner;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$RadioPowerStateChange implements MultiBindIndexedProvider<RadioPowerStateChange>, Provider<Set<RadioPowerStateChange>> {
    private final InjectorLike f11183a;

    public STATICDI_MULTIBIND_PROVIDER$RadioPowerStateChange(InjectorLike injectorLike) {
        this.f11183a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11183a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return RadioBasedBackgroundTaskRunner.m11103a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
