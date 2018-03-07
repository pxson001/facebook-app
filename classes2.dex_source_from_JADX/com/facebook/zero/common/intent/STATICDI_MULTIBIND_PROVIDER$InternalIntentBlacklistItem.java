package com.facebook.zero.common.intent;

import com.facebook.friendsnearby.zerorating.FriendsNearbyInternalIntentBlacklistItem;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.activity.nearby.NearbyInternalIntentBlacklistItem;
import com.facebook.katana.activity.places.PlacesInternalIntentBlacklistItem;
import com.facebook.katana.activity.places.SelectAtTagInternalIntentBlacklistItem;
import com.facebook.neko.getgamesneko.zerorating.GetGamesNekoInternalIntentBlacklistItem;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.timeline.zero.TimelineInternalIntentBlacklistItem;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$InternalIntentBlacklistItem implements MultiBindIndexedProvider<InternalIntentBlacklistItem>, Provider<Set<InternalIntentBlacklistItem>> {
    private final InjectorLike f23255a;

    public STATICDI_MULTIBIND_PROVIDER$InternalIntentBlacklistItem(InjectorLike injectorLike) {
        this.f23255a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f23255a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new FriendsNearbyInternalIntentBlacklistItem(IdBasedProvider.m1811a(injector, 12), GatekeeperStoreImplMethodAutoProvider.m2131a(injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new NearbyInternalIntentBlacklistItem(IdBasedProvider.m1811a(injector, 12));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new PlacesInternalIntentBlacklistItem();
            case 3:
                return new SelectAtTagInternalIntentBlacklistItem();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new GetGamesNekoInternalIntentBlacklistItem();
            case 5:
                return new TimelineInternalIntentBlacklistItem();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
