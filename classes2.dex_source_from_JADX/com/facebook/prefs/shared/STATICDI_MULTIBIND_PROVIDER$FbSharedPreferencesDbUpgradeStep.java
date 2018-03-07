package com.facebook.prefs.shared;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.internal.GkInternalModule;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbSharedPreferencesDbUpgradeStep implements MultiBindIndexedProvider<FbSharedPreferencesDbUpgradeStep>, Provider<Set<FbSharedPreferencesDbUpgradeStep>> {
    private final InjectorLike f1028a;

    public STATICDI_MULTIBIND_PROVIDER$FbSharedPreferencesDbUpgradeStep(InjectorLike injectorLike) {
        this.f1028a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1028a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return GkInternalModule.a(GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injector), GatekeeperStoreImpl_SessionlessMethodAutoProvider.m2714a(injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return GkInternalModule.b(GatekeeperStoreImplMethodAutoProvider.m2131a(injector), GatekeeperStoreImplMethodAutoProvider.m2131a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
