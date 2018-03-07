package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: cached_value_found */
public final class GeneralRange<T> implements Serializable {
    public final Comparator<? super T> comparator;
    public final boolean hasLowerBound;
    public final boolean hasUpperBound;
    public final BoundType lowerBoundType;
    @Nullable
    public final T lowerEndpoint;
    public final BoundType upperBoundType;
    @Nullable
    public final T upperEndpoint;

    static <T> GeneralRange<T> m13342a(Comparator<? super T> comparator) {
        return new GeneralRange(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    public GeneralRange(Comparator<? super T> comparator, boolean z, @Nullable T t, BoundType boundType, boolean z2, @Nullable T t2, BoundType boundType2) {
        int i = 1;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", new Object[]{t, t2});
            if (compare == 0) {
                int i2;
                if (boundType != BoundType.OPEN) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (boundType2 == BoundType.OPEN) {
                    i = 0;
                }
                Preconditions.checkArgument(i2 | i);
            }
        }
    }

    final boolean m13344a(@Nullable T t) {
        int i = 1;
        if (!this.hasLowerBound) {
            return false;
        }
        int compare = this.comparator.compare(t, this.lowerEndpoint);
        int i2 = compare < 0 ? 1 : 0;
        compare = compare == 0 ? 1 : 0;
        if (this.lowerBoundType != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (compare & i);
    }

    final boolean m13345b(@Nullable T t) {
        int i = 1;
        if (!this.hasUpperBound) {
            return false;
        }
        int compare = this.comparator.compare(t, this.upperEndpoint);
        int i2 = compare > 0 ? 1 : 0;
        compare = compare == 0 ? 1 : 0;
        if (this.upperBoundType != BoundType.OPEN) {
            i = 0;
        }
        return i2 | (compare & i);
    }

    public final boolean m13346c(@Nullable T t) {
        return (m13344a((Object) t) || m13345b(t)) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final com.google.common.collect.GeneralRange<T> m13343a(com.google.common.collect.GeneralRange<T> r12) {
        /*
        r11 = this;
        com.google.common.base.Preconditions.checkNotNull(r12);
        r0 = r11.comparator;
        r1 = r12.comparator;
        r0 = r0.equals(r1);
        com.google.common.base.Preconditions.checkArgument(r0);
        r0 = r11.hasLowerBound;
        r10 = r11.lowerEndpoint;
        r2 = r10;
        r10 = r11.lowerBoundType;
        r1 = r10;
        r10 = r11.hasLowerBound;
        r3 = r10;
        if (r3 != 0) goto L_0x0061;
    L_0x001b:
        r0 = r12.hasLowerBound;
    L_0x001d:
        r10 = r12.lowerEndpoint;
        r2 = r10;
        r10 = r12.lowerBoundType;
        r1 = r10;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
    L_0x0027:
        r3 = r11.hasUpperBound;
        r10 = r11.upperEndpoint;
        r6 = r10;
        r10 = r11.upperBoundType;
        r7 = r10;
        r10 = r11.hasUpperBound;
        r4 = r10;
        if (r4 != 0) goto L_0x0082;
    L_0x0034:
        r3 = r12.hasUpperBound;
    L_0x0036:
        r10 = r12.upperEndpoint;
        r6 = r10;
        r10 = r12.upperBoundType;
        r7 = r10;
        r5 = r3;
    L_0x003d:
        if (r2 == 0) goto L_0x00a0;
    L_0x003f:
        if (r5 == 0) goto L_0x00a0;
    L_0x0041:
        r3 = r11.comparator;
        r3 = r3.compare(r1, r6);
        if (r3 > 0) goto L_0x0053;
    L_0x0049:
        if (r3 != 0) goto L_0x00a0;
    L_0x004b:
        r3 = com.google.common.collect.BoundType.OPEN;
        if (r0 != r3) goto L_0x00a0;
    L_0x004f:
        r3 = com.google.common.collect.BoundType.OPEN;
        if (r7 != r3) goto L_0x00a0;
    L_0x0053:
        r0 = com.google.common.collect.BoundType.OPEN;
        r7 = com.google.common.collect.BoundType.CLOSED;
        r4 = r0;
        r3 = r6;
    L_0x0059:
        r0 = new com.google.common.collect.GeneralRange;
        r1 = r11.comparator;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        return r0;
    L_0x0061:
        r10 = r12.hasLowerBound;
        r3 = r10;
        if (r3 == 0) goto L_0x007d;
    L_0x0066:
        r3 = r11.comparator;
        r10 = r11.lowerEndpoint;
        r4 = r10;
        r10 = r12.lowerEndpoint;
        r5 = r10;
        r3 = r3.compare(r4, r5);
        if (r3 < 0) goto L_0x001d;
    L_0x0074:
        if (r3 != 0) goto L_0x007d;
    L_0x0076:
        r10 = r12.lowerBoundType;
        r3 = r10;
        r4 = com.google.common.collect.BoundType.OPEN;
        if (r3 == r4) goto L_0x001d;
    L_0x007d:
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0027;
    L_0x0082:
        r10 = r12.hasUpperBound;
        r4 = r10;
        if (r4 == 0) goto L_0x009e;
    L_0x0087:
        r4 = r11.comparator;
        r10 = r11.upperEndpoint;
        r5 = r10;
        r10 = r12.upperEndpoint;
        r8 = r10;
        r4 = r4.compare(r5, r8);
        if (r4 > 0) goto L_0x0036;
    L_0x0095:
        if (r4 != 0) goto L_0x009e;
    L_0x0097:
        r10 = r12.upperBoundType;
        r4 = r10;
        r5 = com.google.common.collect.BoundType.OPEN;
        if (r4 == r5) goto L_0x0036;
    L_0x009e:
        r5 = r3;
        goto L_0x003d;
    L_0x00a0:
        r4 = r0;
        r3 = r1;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.GeneralRange.a(com.google.common.collect.GeneralRange):com.google.common.collect.GeneralRange<T>");
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        if (this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && this.lowerBoundType.equals(generalRange.lowerBoundType) && this.upperBoundType.equals(generalRange.upperBoundType) && Objects.equal(this.lowerEndpoint, generalRange.lowerEndpoint) && Objects.equal(this.upperEndpoint, generalRange.upperEndpoint)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.comparator, this.lowerEndpoint, this.lowerBoundType, this.upperEndpoint, this.upperBoundType});
    }

    public final String toString() {
        return this.comparator + ":" + (this.lowerBoundType == BoundType.CLOSED ? '[' : '(') + (this.hasLowerBound ? this.lowerEndpoint : "-∞") + ',' + (this.hasUpperBound ? this.upperEndpoint : "∞") + (this.upperBoundType == BoundType.CLOSED ? ']' : ')');
    }
}
