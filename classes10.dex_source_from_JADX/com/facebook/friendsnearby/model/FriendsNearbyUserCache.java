package com.facebook.friendsnearby.model;

import com.facebook.user.model.User;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

/* compiled from: _deselections */
public class FriendsNearbyUserCache {
    public final HashMap<String, User> f20581a = Maps.c();

    public final void m20990a(String str, User user) {
        this.f20581a.put(str, user);
    }

    public final void m20991a(Map<String, User> map) {
        this.f20581a.putAll(map);
    }
}
