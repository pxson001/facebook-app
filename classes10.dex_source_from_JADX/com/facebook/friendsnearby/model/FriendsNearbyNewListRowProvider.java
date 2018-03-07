package com.facebook.friendsnearby.model;

import android.net.Uri;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: a2 */
public class FriendsNearbyNewListRowProvider extends AbstractAssistedProvider<FriendsNearbyNewListRow> {
    public final FriendsNearbyNewListRow m20915a(String str, Uri uri, String str2, String str3, String str4, String str5, String str6, boolean z) {
        return new FriendsNearbyNewListRow(str, uri, str2, str3, str4, str5, str6, z, GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
