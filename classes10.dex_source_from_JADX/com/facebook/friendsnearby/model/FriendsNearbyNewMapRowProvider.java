package com.facebook.friendsnearby.model;

import android.net.Uri;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.location.ImmutableLocation;

/* compiled from: a-place-for */
public class FriendsNearbyNewMapRowProvider extends AbstractAssistedProvider<FriendsNearbyNewMapRow> {
    public final FriendsNearbyNewMapRow m20918a(String str, Uri uri, String str2, String str3, String str4, String str5, boolean z, ImmutableLocation immutableLocation) {
        return new FriendsNearbyNewMapRow(str, uri, str2, str3, str4, str5, z, immutableLocation, GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
