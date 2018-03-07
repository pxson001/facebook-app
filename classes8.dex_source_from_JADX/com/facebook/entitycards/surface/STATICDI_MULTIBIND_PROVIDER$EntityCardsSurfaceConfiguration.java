package com.facebook.entitycards.surface;

import com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsSurfaceConfiguration;
import com.facebook.friendsnearby.entitycards.surface.FriendsNearbyEntityCardsSurfaceConfiguration;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.qrcode.entitycards.QRCodeEntityCardsSurfaceConfiguration;
import com.facebook.timeline.entitycards.TimelineEntityCardsSurfaceConfiguration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class STATICDI_MULTIBIND_PROVIDER$EntityCardsSurfaceConfiguration implements MultiBindIndexedProvider<EntityCardsSurfaceConfiguration>, Provider<Set<EntityCardsSurfaceConfiguration>> {
    private final InjectorLike f11089a;

    public STATICDI_MULTIBIND_PROVIDER$EntityCardsSurfaceConfiguration(InjectorLike injectorLike) {
        this.f11089a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11089a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FriendRequestsEntityCardsSurfaceConfiguration.m14960a(injector);
            case 1:
                return FriendsNearbyEntityCardsSurfaceConfiguration.a(injector);
            case 2:
                return QRCodeEntityCardsSurfaceConfiguration.a(injector);
            case 3:
                return TimelineEntityCardsSurfaceConfiguration.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
