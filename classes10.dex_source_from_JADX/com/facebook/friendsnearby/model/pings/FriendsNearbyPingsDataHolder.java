package com.facebook.friendsnearby.model.pings;

import com.facebook.friendsnearby.model.FriendsNearbyNewMapRow;
import com.facebook.friendsnearby.model.FriendsNearbyOutgoingPingRow;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: __dequeue */
public class FriendsNearbyPingsDataHolder {
    public final ArrayList<FriendsNearbyOutgoingPingRow> f20589a = Lists.a();
    public final HashMap<String, FriendsNearbyOutgoingPingRow> f20590b = Maps.c();
    public final ArrayList<FriendsNearbyNewMapRow> f20591c = Lists.a();
    private final HashMap<String, FriendsNearbyNewMapRow> f20592d = Maps.c();

    public final void m20995a(String str, FriendsNearbyOutgoingPingRow friendsNearbyOutgoingPingRow) {
        this.f20589a.add(friendsNearbyOutgoingPingRow);
        this.f20590b.put(str, friendsNearbyOutgoingPingRow);
    }

    public final void m20994a(String str, FriendsNearbyNewMapRow friendsNearbyNewMapRow) {
        this.f20591c.add(friendsNearbyNewMapRow);
        this.f20592d.put(str, friendsNearbyNewMapRow);
    }

    public final boolean m20996b(String str) {
        return this.f20590b.containsKey(str);
    }

    public final ImmutableSet<String> m20997c() {
        return ImmutableSet.copyOf(this.f20590b.keySet());
    }
}
