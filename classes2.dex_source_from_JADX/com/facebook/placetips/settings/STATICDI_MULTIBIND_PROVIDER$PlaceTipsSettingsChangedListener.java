package com.facebook.placetips.settings;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.placetips.presence.PresenceResetListener;
import com.facebook.placetips.pulsarcore.PulsarFeatureController;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$PlaceTipsSettingsChangedListener implements MultiBindIndexedProvider<PlaceTipsSettingsChangedListener>, Provider<Set<PlaceTipsSettingsChangedListener>> {
    private final InjectorLike f14882a;

    public STATICDI_MULTIBIND_PROVIDER$PlaceTipsSettingsChangedListener(InjectorLike injectorLike) {
        this.f14882a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f14882a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PresenceResetListener.b(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return PulsarFeatureController.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return PlaceTipsRuntimeSettingsManager.m21404a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
