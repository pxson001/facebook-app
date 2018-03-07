package com.facebook.workingrange.core;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: onCreate */
public class WorkingRangeBoundsPair {
    public WorkingRangeBounds f11144a;
    public WorkingRangeBounds f11145b;

    public final void m16472b(@Nullable WorkingRangeBounds workingRangeBounds, @Nullable WorkingRangeBounds workingRangeBounds2) {
        this.f11144a = workingRangeBounds;
        this.f11145b = workingRangeBounds2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WorkingRangeBoundsPair)) {
            return false;
        }
        WorkingRangeBoundsPair workingRangeBoundsPair = (WorkingRangeBoundsPair) obj;
        if (Objects.equal(this.f11144a, workingRangeBoundsPair.f11144a) && Objects.equal(this.f11145b, workingRangeBoundsPair.f11145b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.f11144a != null) {
            i = this.f11144a.hashCode() + 0;
        }
        if (this.f11145b != null) {
            i += this.f11145b.hashCode();
        }
        return i * 31;
    }
}
