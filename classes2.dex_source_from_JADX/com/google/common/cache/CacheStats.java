package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zeroUpdateStatusParams */
public final class CacheStats {
    private final long f564a;
    private final long f565b;
    private final long f566c;
    private final long f567d;
    private final long f568e;
    private final long f569f;

    public CacheStats(long j, long j2, long j3, long j4, long j5, long j6) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j2 >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j4 >= 0);
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        this.f564a = j;
        this.f565b = j2;
        this.f566c = j3;
        this.f567d = j4;
        this.f568e = j5;
        this.f569f = j6;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f564a), Long.valueOf(this.f565b), Long.valueOf(this.f566c), Long.valueOf(this.f567d), Long.valueOf(this.f568e), Long.valueOf(this.f569f));
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.f564a == cacheStats.f564a && this.f565b == cacheStats.f565b && this.f566c == cacheStats.f566c && this.f567d == cacheStats.f567d && this.f568e == cacheStats.f568e && this.f569f == cacheStats.f569f) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Object) this).add("hitCount", this.f564a).add("missCount", this.f565b).add("loadSuccessCount", this.f566c).add("loadExceptionCount", this.f567d).add("totalLoadTime", this.f568e).add("evictionCount", this.f569f).toString();
    }
}
