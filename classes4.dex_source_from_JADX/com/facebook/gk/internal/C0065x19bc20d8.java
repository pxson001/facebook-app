package com.facebook.gk.internal;

import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
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
public final class C0065x19bc20d8 implements MultiBindIndexedProvider<GatekeeperFetchListener>, Provider<Set<GatekeeperFetchListener>> {
    private final InjectorLike f999a;

    public C0065x19bc20d8(InjectorLike injectorLike) {
        this.f999a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f999a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new SessionlessGkUpdater((FbSharedPreferences) FbSharedPreferencesImpl.a(injector), (GatekeeperWriter) GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
