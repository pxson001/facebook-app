package com.facebook.friendsnearby.model;

import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyContactsTab;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyHighlightQuery;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingFields;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingQuery.PrivacySettings;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyViewerInfo;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: a72d26c1855cedf439f2a5657142345b */
public class DashboardModel {
    public final Optional<FriendsNearbyViewerInfo> f20460a;
    public final Optional<FriendsNearbyLocationSharingFields> f20461b;
    public final Optional<PrivacySettings> f20462c;
    public final Optional<FriendsNearbyContactsTab> f20463d;
    public final Optional<ImmutableList<FriendsNearbyHighlightQuery>> f20464e;

    public DashboardModel(Optional<FriendsNearbyViewerInfo> optional, Optional<FriendsNearbyLocationSharingFields> optional2, Optional<PrivacySettings> optional3, Optional<FriendsNearbyContactsTab> optional4, Optional<ImmutableList<FriendsNearbyHighlightQuery>> optional5) {
        this.f20460a = optional;
        this.f20461b = optional2;
        this.f20462c = optional3;
        this.f20463d = optional4;
        this.f20464e = optional5;
    }
}
