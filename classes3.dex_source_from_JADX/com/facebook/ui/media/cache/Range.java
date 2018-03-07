package com.facebook.ui.media.cache;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: No Content-Type header */
public class Range {
    public final long f419a;
    public final long f420b;

    public Range(long j, long j2) {
        Preconditions.checkArgument(j < j2, "From must be lower than to [" + j + ", " + j2 + ")");
        this.f419a = j;
        this.f420b = j2;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f419a), Long.valueOf(this.f420b)});
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (this.f419a == range.f419a && this.f420b == range.f420b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "[" + this.f419a + ", " + this.f420b + ")";
    }

    public final long m386a() {
        return this.f420b - this.f419a;
    }

    public final boolean m388a(long j) {
        return this.f419a <= j && j < this.f420b;
    }

    public final ImmutableList<Range> m387a(Iterable<Range> iterable) {
        Builder builder = ImmutableList.builder();
        for (Range range : iterable) {
            Range range2;
            long max = Math.max(this.f419a, range.f419a);
            long min = Math.min(this.f420b, range.f420b);
            if (max >= min) {
                range2 = null;
            } else {
                range2 = new Range(max, min);
            }
            Range range3 = range2;
            if (range3 != null) {
                builder.c(range3);
            }
        }
        return builder.b();
    }

    public final ImmutableList<Range> m389b(Iterable<Range> iterable) {
        Builder builder = ImmutableList.builder();
        ImmutableList<Range> a = m387a((Iterable) iterable);
        long j = this.f419a;
        long j2 = j;
        for (Range range : a) {
            if (j2 < range.f419a) {
                builder.c(new Range(j2, range.f419a));
            }
            j2 = range.f420b;
        }
        if (j2 < this.f420b) {
            builder.c(new Range(j2, this.f420b));
        }
        return builder.b();
    }

    public final ImmutableList<Range> m390c(Iterable<Range> iterable) {
        Builder builder = ImmutableList.builder();
        long j = this.f419a;
        long j2 = this.f420b;
        Object obj = null;
        for (Range range : iterable) {
            Object obj2 = range.f420b < this.f419a ? 1 : null;
            Object obj3 = this.f420b < range.f419a ? 1 : null;
            if (obj2 != null) {
                builder.c(range);
            } else if (obj3 == null) {
                j = Math.min(j, range.f419a);
                j2 = Math.max(j2, range.f420b);
            } else {
                if (obj == null) {
                    obj = 1;
                    builder.c(new Range(j, j2));
                }
                builder.c(range);
            }
        }
        if (obj == null) {
            builder.c(new Range(j, j2));
        }
        return builder.b();
    }
}
