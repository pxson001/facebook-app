package com.facebook.friendsnearby.model.sections;

import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.model.SimpleOrderedMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;

/* compiled from: __callbackToken */
public class FriendsNearbySectionsDataHolder {
    public final LinkedHashMap<String, FriendsNearbySection> f20606a = Maps.d();
    public final SimpleOrderedMultimap f20607b = new SimpleOrderedMultimap();

    public final ImmutableList<FriendsNearbySection> m21012a() {
        return ImmutableList.copyOf(this.f20606a.values());
    }

    public final void m21013a(String str, FriendsNearbySection friendsNearbySection) {
        this.f20606a.put(str, friendsNearbySection);
        for (FriendsNearbyRow friendsNearbyRow : friendsNearbySection.e()) {
            this.f20607b.m20993a(friendsNearbyRow.mo908a(), friendsNearbyRow);
        }
    }

    @Nullable
    public final ImmutableSet<FriendsNearbyRow> m21014b(String str) {
        Collection a = this.f20607b.m20992a(str);
        return a == null ? null : ImmutableSet.copyOf(a);
    }
}
