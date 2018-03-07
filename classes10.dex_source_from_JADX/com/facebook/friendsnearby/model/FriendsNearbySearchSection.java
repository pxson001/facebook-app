package com.facebook.friendsnearby.model;

import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: _last_name */
public class FriendsNearbySearchSection extends FriendsNearbySection {
    public final ImmutableList<FriendsNearbyRow> f20550a;

    public FriendsNearbySearchSection(String str, ImmutableList<FriendsNearbyRow> immutableList) {
        super(str);
        a(true);
        this.f20550a = immutableList;
    }

    protected final List<FriendsNearbyRow> m20957d() {
        return this.f20550a;
    }

    public final List<FriendsNearbyRow> m20958e() {
        return this.f20550a;
    }

    public final String mo922g() {
        return "friends_nearby_search_section";
    }

    public final void mo921a(ImmutableList<FriendsNearbyRow> immutableList) {
        throw new UnsupportedOperationException();
    }
}
