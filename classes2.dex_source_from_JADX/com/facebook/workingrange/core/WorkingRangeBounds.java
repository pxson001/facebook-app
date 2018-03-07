package com.facebook.workingrange.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* compiled from: onCreateLayout */
public class WorkingRangeBounds {
    public static final WorkingRangeBounds f11138a;
    public static final WorkingRangeBoundsPair f11139b;
    public static final WorkingRangeBounds f11140c = m16467c(Integer.MIN_VALUE, Integer.MIN_VALUE);
    public int f11141d = -1;
    public int f11142e = -1;
    public boolean f11143f = false;

    static {
        WorkingRangeBounds c = m16467c(-1, -1);
        f11138a = c;
        WorkingRangeBoundsPair workingRangeBoundsPair = new WorkingRangeBoundsPair();
        workingRangeBoundsPair.m16472b(c, null);
        f11139b = workingRangeBoundsPair;
    }

    WorkingRangeBounds() {
    }

    final void m16470a(int i, int i2) {
        this.f11141d = i;
        this.f11142e = i2;
    }

    public final void m16469a() {
        this.f11141d = -1;
        this.f11142e = -1;
    }

    private static WorkingRangeBounds m16467c(int i, int i2) {
        WorkingRangeBounds workingRangeBounds = new WorkingRangeBounds();
        workingRangeBounds.m16470a(i, i2);
        workingRangeBounds.f11143f = true;
        return workingRangeBounds;
    }

    public static WorkingRangeBounds m16466b(int i, int i2) {
        Preconditions.checkArgument(i2 >= i, "End must be greater than or equal to start");
        return WorkingRangePools.a(i, i2);
    }

    public int hashCode() {
        return (this.f11141d + this.f11142e) * 31;
    }

    public final WorkingRangeBoundsPair m16468a(WorkingRangeBounds workingRangeBounds) {
        if (m16471e() || workingRangeBounds.m16471e()) {
            return WorkingRangePools.b(m16466b(this.f11141d, this.f11142e));
        }
        Object obj;
        int i = this.f11141d;
        int i2 = this.f11142e;
        int i3 = workingRangeBounds.f11141d;
        int i4 = workingRangeBounds.f11142e;
        if (this.f11141d >= workingRangeBounds.f11141d || this.f11142e <= workingRangeBounds.f11142e) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return WorkingRangePools.a(WorkingRangePools.a(i, i3 - 1), WorkingRangePools.a(i4 + 1, i2));
        }
        if (workingRangeBounds.f11141d > this.f11141d || workingRangeBounds.f11142e < this.f11142e) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return f11139b;
        }
        if (i < i3 && i2 >= i3) {
            i2 = i3 - 1;
        }
        if (i2 > i4 && i <= i4) {
            i = i4 + 1;
        }
        return WorkingRangePools.b(m16466b(i, i2));
    }

    public final boolean m16471e() {
        return this == f11138a || equals(f11138a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WorkingRangeBounds)) {
            return false;
        }
        WorkingRangeBounds workingRangeBounds = (WorkingRangeBounds) obj;
        if (this.f11141d == workingRangeBounds.f11141d && this.f11142e == workingRangeBounds.f11142e) {
            return true;
        }
        return false;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("start", this.f11141d).add("end", this.f11142e).toString();
    }
}
