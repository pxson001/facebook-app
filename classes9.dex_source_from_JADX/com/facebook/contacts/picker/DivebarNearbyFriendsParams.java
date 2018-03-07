package com.facebook.contacts.picker;

import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: post_media */
public class DivebarNearbyFriendsParams {
    public final Mode f6453a;
    @Nullable
    public final ImmutableList<User> f6454b;

    /* compiled from: post_media */
    public enum Mode {
        LOADING,
        NUX,
        UPSELL,
        LOCATION_DISABLED,
        CHAT_CONTEXT_DISABLED,
        LIST
    }

    public DivebarNearbyFriendsParams(Mode mode, ImmutableList<User> immutableList) {
        this.f6453a = mode;
        this.f6454b = immutableList;
    }

    public static DivebarNearbyFriendsParams m6818a(ImmutableList<User> immutableList) {
        return new DivebarNearbyFriendsParams(Mode.LIST, immutableList);
    }
}
