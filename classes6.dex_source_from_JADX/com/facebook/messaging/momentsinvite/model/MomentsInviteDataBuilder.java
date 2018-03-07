package com.facebook.messaging.momentsinvite.model;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: untypedData */
public class MomentsInviteDataBuilder {
    public List<String> f2400a = Collections.emptyList();
    public int f2401b;
    @Nullable
    public String f2402c;
    @Nullable
    public String f2403d;

    public static MomentsInviteDataBuilder newBuilder() {
        return new MomentsInviteDataBuilder();
    }

    public final MomentsInviteDataBuilder m3630a(List<String> list) {
        this.f2400a = (List) Preconditions.checkNotNull(list);
        return this;
    }

    public final MomentsInviteData m3631e() {
        return new MomentsInviteData(this);
    }
}
