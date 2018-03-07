package com.facebook.friendsnearby.model;

import android.net.Uri;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.IncomingLocationPingWithSenderModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.IncomingLocationPingWithSenderModel.SenderModel;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.Assisted;
import com.facebook.location.ImmutableLocation;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: a1342d59122c0491ba28113fa76d41b2 */
public class FriendsNearbyNewMapRow extends FriendsNearbyNewListRow implements FriendsNearbyRow {
    public ImmutableLocation f20518a;

    @Nullable
    public static FriendsNearbyNewMapRow m20916a(IncomingLocationPingWithSenderModel incomingLocationPingWithSenderModel, FriendsNearbyDataUtil friendsNearbyDataUtil, String str, String str2, boolean z, FriendsNearbyNewMapRowProvider friendsNearbyNewMapRowProvider) {
        ImmutableLocation a = FriendsNearbyDataUtil.m20823a(incomingLocationPingWithSenderModel);
        SenderModel nr_ = incomingLocationPingWithSenderModel.nr_();
        if (nr_ == null) {
            return null;
        }
        Uri uri;
        String b = nr_.m21542b();
        DefaultImageFields d = nr_.m21544d();
        if (d == null) {
            uri = null;
        } else {
            uri = Uri.parse(d.b());
        }
        return friendsNearbyNewMapRowProvider.m20918a(b, uri, nr_.m21543c(), incomingLocationPingWithSenderModel.m21555d(), str, str2, z, a);
    }

    @Inject
    public FriendsNearbyNewMapRow(@Assisted String str, @Assisted Uri uri, @Assisted String str2, @Assisted String str3, @Assisted String str4, @Assisted String str5, @Assisted boolean z, @Assisted ImmutableLocation immutableLocation, GatekeeperStoreImpl gatekeeperStoreImpl) {
        super(str, uri, str2, str3, str4, "aura", str5, z, gatekeeperStoreImpl);
        this.f20518a = immutableLocation;
    }

    public final ImmutableLocation m20917j() {
        return this.f20518a;
    }
}
