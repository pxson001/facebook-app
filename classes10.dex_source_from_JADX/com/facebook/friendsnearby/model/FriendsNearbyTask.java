package com.facebook.friendsnearby.model;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: _eventName */
public class FriendsNearbyTask extends TypedKey<FriendsNearbyTask> {
    public static final FriendsNearbyTask f20570d = new FriendsNearbyTask("fetch_nearby_friends");
    public static final FriendsNearbyTask f20571e = new FriendsNearbyTask("fetch_nearby_friends_location_sharing");
    public static final FriendsNearbyTask f20572f = new FriendsNearbyTask("fetch_nearby_friends_contacts_tab");
    public static final FriendsNearbyTask f20573g = new FriendsNearbyTask("fetch_nearby_friends_highlight");
    public static final FriendsNearbyTask f20574h = new FriendsNearbyTask("fetch_location");
    public static final FriendsNearbyTask f20575i = new FriendsNearbyTask("fetch_more_in_section");
    public static final FriendsNearbyTask f20576j = new FriendsNearbyTask("nearby_friends_search");
    public static final FriendsNearbyTask f20577k = new FriendsNearbyTask("save_location");
    public static final FriendsNearbyTask f20578l = new FriendsNearbyTask("turn_in");
    public static final FriendsNearbyTask f20579m = new FriendsNearbyTask("invite_");
    public static final FriendsNearbyTask f20580n = new FriendsNearbyTask("uninvite_");

    private FriendsNearbyTask(String str) {
        super(str);
    }

    private FriendsNearbyTask(TypedKey typedKey, String str) {
        super(typedKey, str);
    }

    protected final TypedKey m20989a(TypedKey typedKey, String str) {
        return new FriendsNearbyTask(typedKey, str);
    }
}
