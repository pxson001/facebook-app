package com.facebook.timeline.datafetcher;

import com.google.common.base.Objects;

/* compiled from: groupInformation or groupId is null in favoriteGroup */
public class TimelineFetchIdentifier {
    public final long f10468a;

    public TimelineFetchIdentifier(long j) {
        this.f10468a = j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TimelineFetchIdentifier)) {
            return false;
        }
        if (this.f10468a == ((TimelineFetchIdentifier) obj).f10468a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f10468a)});
    }
}
