package com.facebook.gk.internal;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$GatekeeperFetchListener implements MultiBindIndexedProvider<GatekeeperFetchListener>, Provider<Set<GatekeeperFetchListener>> {
    private final InjectorLike f1551a;

    public STATICDI_MULTIBIND_PROVIDER$GatekeeperFetchListener(InjectorLike injectorLike) {
        this.f1551a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1551a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new GatekeeperUpdateListener((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), (GatekeeperWriter) GatekeeperStoreImplMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
