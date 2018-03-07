package com.facebook.omnistore.module;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.interstitial.omnistore.InterstitialOmnistoreComponent;
import com.facebook.messaging.bannertriggers.BannerTriggersOmnistoreComponent;
import com.facebook.messaging.prefs.omnistore.MessengerUserPrefsOmnistoreComponent;
import com.facebook.messaging.tincan.inbound.ConnectionReceiver;
import com.facebook.messaging.tincan.inbound.MessageReceiver;
import com.facebook.messaging.tincan.outbound.Sender;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$OmnistoreComponent implements MultiBindIndexedProvider<OmnistoreComponent>, Provider<Set<OmnistoreComponent>> {
    public final InjectorLike mInjector;

    public STATICDI_MULTIBIND_PROVIDER$OmnistoreComponent(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return new MultiBinderSet(this.mInjector.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<OmnistoreComponent>> getLazySet(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$OmnistoreComponent(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public static Set<OmnistoreComponent> getSet(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$OmnistoreComponent(injectorLike));
    }

    public final int size() {
        return 6;
    }

    public final OmnistoreComponent provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return InterstitialOmnistoreComponent.a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return BannerTriggersOmnistoreComponent.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return MessengerUserPrefsOmnistoreComponent.a(injector);
            case 3:
                return ConnectionReceiver.a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return MessageReceiver.a(injector);
            case 5:
                return Sender.m22110a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
