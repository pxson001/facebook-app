package com.facebook.timeline.context;

import android.os.ParcelUuid;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.ipc.profile.TimelineContext.TimelineType;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: feather_overlay_start */
public class TimelineUserContext extends TimelineContext {
    public final FriendRequestMakeRef f14568a;
    public final Optional<String> f14569b;
    private final boolean f14570c;

    public static TimelineUserContext m18454a(long j, long j2, String str, ParcelUuid parcelUuid) {
        return new TimelineUserContext(j, j2, str, TimelineType.USER, parcelUuid, null, Absent.withType(), false);
    }

    public final Optional<String> m18460e() {
        return Absent.INSTANCE;
    }

    public static TimelineUserContext m18455a(long j, long j2, String str, ParcelUuid parcelUuid, FriendRequestMakeRef friendRequestMakeRef, Optional<String> optional, boolean z) {
        return new TimelineUserContext(j, j2, str, TimelineType.USER, parcelUuid, friendRequestMakeRef, optional, z);
    }

    private TimelineUserContext(long j, long j2, String str, TimelineType timelineType, ParcelUuid parcelUuid, @Nullable FriendRequestMakeRef friendRequestMakeRef, Optional<String> optional, boolean z) {
        super(j, j2, str, timelineType, parcelUuid);
        this.f14568a = friendRequestMakeRef;
        this.f14569b = optional;
        this.f14570c = z;
    }

    public final boolean m18456a() {
        return i();
    }

    public final boolean m18457b() {
        return i();
    }

    public final boolean m18458c() {
        return i();
    }

    public final boolean m18459d() {
        return this.f14570c;
    }
}
