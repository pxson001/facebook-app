package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: WearableClient */
public class FriendsNearbyMapPingOpenInUberAction extends FriendsNearbyMapPingAction {
    public final Context f20985a;
    public final GatekeeperStoreImpl f20986b;

    public static FriendsNearbyMapPingOpenInUberAction m21972b(InjectorLike injectorLike) {
        return new FriendsNearbyMapPingOpenInUberAction((Context) injectorLike.getInstance(Context.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsNearbyMapPingOpenInUberAction(Context context, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f20985a = context;
        this.f20986b = gatekeeperStoreImpl;
    }

    public final String mo948a() {
        return this.f20985a.getString(2131242023);
    }

    public final String mo949b() {
        return "uber";
    }

    public final Optional<Intent> mo947a(ImmutableLocation immutableLocation, String str) {
        Preconditions.checkNotNull(immutableLocation);
        return this.f20986b.a(1159, false) ? Optional.of(new Intent().setAction("android.intent.action.VIEW").setData(Uri.parse("uber://?action=setPickup").buildUpon().appendQueryParameter("pickup", "my_location").appendQueryParameter("dropoff[latitude]", Double.toString(immutableLocation.a())).appendQueryParameter("dropoff[longitude]", Double.toString(immutableLocation.b())).appendQueryParameter("dropoff[nickname]", this.f20985a.getString(2131242020, new Object[]{str})).build())) : Absent.INSTANCE;
    }
}
