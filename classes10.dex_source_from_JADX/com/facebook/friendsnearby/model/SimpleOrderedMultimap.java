package com.facebook.friendsnearby.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: _background */
public class SimpleOrderedMultimap {
    private final HashMap<String, List<FriendsNearbyRow>> f20582a = Maps.c();
    private final Map<String, FriendsNearbyRow> f20583b = Maps.c();

    public final List<FriendsNearbyRow> m20992a(String str) {
        if (this.f20582a.containsKey(str)) {
            return (List) this.f20582a.get(str);
        }
        return null;
    }

    public final void m20993a(String str, FriendsNearbyRow friendsNearbyRow) {
        if (str == null || friendsNearbyRow == null) {
            throw new IllegalArgumentException();
        }
        List list;
        if (this.f20582a.containsKey(str)) {
            list = (List) this.f20582a.get(str);
            list.add(friendsNearbyRow);
            this.f20582a.put(str, list);
        } else {
            list = Lists.b();
            list.add(friendsNearbyRow);
            this.f20582a.put(str, list);
        }
        if (!this.f20583b.containsKey(str)) {
            this.f20583b.put(str, friendsNearbyRow);
        }
    }
}
