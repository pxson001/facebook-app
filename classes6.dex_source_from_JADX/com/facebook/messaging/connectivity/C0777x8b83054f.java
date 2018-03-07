package com.facebook.messaging.connectivity;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.business.commerceui.connectivity.CommerceWifiConnectivityListener;
import com.facebook.messaging.connectivity.ConnectivityBroadcastReceiver.ConnectivityListener;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class C0777x8b83054f implements MultiBindIndexedProvider<ConnectivityListener>, Provider<Set<ConnectivityListener>> {
    private final InjectorLike f12041a;

    public C0777x8b83054f(InjectorLike injectorLike) {
        this.f12041a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f12041a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return CommerceWifiConnectivityListener.b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
