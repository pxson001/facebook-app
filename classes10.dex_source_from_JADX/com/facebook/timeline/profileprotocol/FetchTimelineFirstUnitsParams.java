package com.facebook.timeline.profileprotocol;

import javax.annotation.Nullable;

/* compiled from: feed_filter_selected_index */
public class FetchTimelineFirstUnitsParams {
    public final long f12088a;
    public final String f12089b;
    public final boolean f12090c;

    /* compiled from: feed_filter_selected_index */
    public enum QueryType {
        USER,
        PAGE
    }

    public FetchTimelineFirstUnitsParams(long j, @Nullable String str, boolean z) {
        this.f12088a = j;
        this.f12089b = str;
        this.f12090c = z;
    }

    public final long m12092a() {
        return this.f12088a;
    }
}
