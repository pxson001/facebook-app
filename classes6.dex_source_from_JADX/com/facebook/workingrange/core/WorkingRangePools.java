package com.facebook.workingrange.core;

import android.support.v4.util.Pools.SimplePool;
import javax.annotation.Nullable;

/* compiled from: com.facebook.platform.extra.SUBTITLE */
public class WorkingRangePools {
    private static final SimplePool<WorkingRangeBounds> f20201a = new SimplePool(32);
    private static final SimplePool<WorkingRangeBoundsPair> f20202b = new SimplePool(32);

    static WorkingRangeBounds m28815a(int i, int i2) {
        WorkingRangeBounds workingRangeBounds = (WorkingRangeBounds) f20201a.a();
        if (workingRangeBounds == null) {
            workingRangeBounds = new WorkingRangeBounds();
        }
        workingRangeBounds.a(i, i2);
        return workingRangeBounds;
    }

    static void m28818a(WorkingRangeBoundsPair workingRangeBoundsPair) {
        if (workingRangeBoundsPair.a != null) {
            workingRangeBoundsPair.a.a();
        }
        if (workingRangeBoundsPair.b != null) {
            workingRangeBoundsPair.b.a();
        }
        f20202b.a(workingRangeBoundsPair);
    }

    static WorkingRangeBoundsPair m28819b(@Nullable WorkingRangeBounds workingRangeBounds) {
        return m28816a(workingRangeBounds, null);
    }

    static WorkingRangeBoundsPair m28816a(@Nullable WorkingRangeBounds workingRangeBounds, @Nullable WorkingRangeBounds workingRangeBounds2) {
        WorkingRangeBoundsPair workingRangeBoundsPair = (WorkingRangeBoundsPair) f20202b.a();
        if (workingRangeBoundsPair == null) {
            workingRangeBoundsPair = new WorkingRangeBoundsPair();
        }
        workingRangeBoundsPair.b(workingRangeBounds, workingRangeBounds2);
        return workingRangeBoundsPair;
    }

    static void m28817a(WorkingRangeBounds workingRangeBounds) {
        Object obj;
        if (workingRangeBounds.f) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            workingRangeBounds.a();
            f20201a.a(workingRangeBounds);
        }
    }
}
