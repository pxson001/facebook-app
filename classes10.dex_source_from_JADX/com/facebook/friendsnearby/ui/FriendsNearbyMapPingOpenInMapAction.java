package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.content.Intent;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.maps.ExternalMapLauncher;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: WearableLS */
public class FriendsNearbyMapPingOpenInMapAction extends FriendsNearbyMapPingAction {
    private final Context f20984a;

    public static FriendsNearbyMapPingOpenInMapAction m21968b(InjectorLike injectorLike) {
        return new FriendsNearbyMapPingOpenInMapAction((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FriendsNearbyMapPingOpenInMapAction(Context context) {
        this.f20984a = context;
    }

    public final String mo948a() {
        return this.f20984a.getString(2131242022);
    }

    public final String mo949b() {
        return "maps";
    }

    public final Optional<Intent> mo947a(ImmutableLocation immutableLocation, String str) {
        return Optional.of(ExternalMapLauncher.a(this.f20984a, immutableLocation.a(), immutableLocation.b(), null));
    }
}
