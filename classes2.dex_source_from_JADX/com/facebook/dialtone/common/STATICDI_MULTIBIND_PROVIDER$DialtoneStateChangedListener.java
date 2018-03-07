package com.facebook.dialtone.common;

import com.facebook.analytics.timespent.TimeSpentEventReporter;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.dialtone.cachemanager.DialtoneCacheManagerStateChangedListener;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.service.FbZeroTokenManager;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$DialtoneStateChangedListener implements MultiBindIndexedProvider<DialtoneStateChangedListener>, Provider<Set<DialtoneStateChangedListener>> {
    private final InjectorLike f4599a;

    public STATICDI_MULTIBIND_PROVIDER$DialtoneStateChangedListener(InjectorLike injectorLike) {
        this.f4599a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4599a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<DialtoneStateChangedListener>> m8357a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$DialtoneStateChangedListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return TimeSpentEventReporter.m20164a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new DialtoneCacheManagerStateChangedListener(C0055x2995691a.m1881a(injector), IdBasedLazy.m1808a(injector, 5487));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return FbZeroTokenManager.m7926b((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
