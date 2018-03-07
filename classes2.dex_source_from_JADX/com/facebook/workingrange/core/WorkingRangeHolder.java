package com.facebook.workingrange.core;

import android.support.v4.util.SimpleArrayMap;
import com.google.common.base.Objects;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: onExitFullScreen() is called before entering full screen */
public class WorkingRangeHolder<Item, Snapshot extends WorkingRangeSnapshot<Item>> {
    private final WorkingRange<Item, Snapshot> f11133a;
    public final SimpleArrayMap<WorkingRangeListener<Item, Snapshot>, Boolean> f11134b = new SimpleArrayMap();
    public final HashSet<Item> f11135c = new HashSet(16);
    private final HashSet<Item> f11136d = new HashSet(16);
    private WorkingRangeBounds f11137e = WorkingRangeBounds.f11138a;

    public WorkingRangeHolder(WorkingRange<Item, Snapshot> workingRange) {
        this.f11133a = workingRange;
    }

    public final void m16463a(Snapshot snapshot) {
        WorkingRangeBounds a = this.f11133a.m16465a(snapshot);
        if (!Objects.equal(this.f11137e, a) && a != WorkingRangeBounds.f11140c) {
            m16459a((WorkingRangeSnapshot) snapshot, a);
        }
    }

    public final void m16464b(Snapshot snapshot) {
        WorkingRangeBounds a = this.f11133a.m16465a(snapshot);
        if (a != WorkingRangeBounds.f11140c) {
            this.f11136d.addAll(this.f11135c);
            m16458a(a, this.f11136d, snapshot);
            Iterator it = this.f11136d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                int size = this.f11134b.size();
                for (int i = 0; i < size; i++) {
                    ((BaseWorkingRangeListener) this.f11134b.b(i)).mo2116a(next, Integer.MIN_VALUE, snapshot);
                }
            }
            this.f11136d.clear();
            WorkingRangePools.a(this.f11137e);
            this.f11137e = a;
        }
    }

    private void m16459a(Snapshot snapshot, WorkingRangeBounds workingRangeBounds) {
        WorkingRangeBoundsPair a = this.f11137e.m16468a(workingRangeBounds);
        WorkingRangeBoundsPair a2 = workingRangeBounds.m16468a(this.f11137e);
        m16461b(a2.f11144a, snapshot);
        m16461b(a2.f11145b, snapshot);
        m16457a(a.f11144a, (WorkingRangeSnapshot) snapshot);
        m16457a(a.f11145b, (WorkingRangeSnapshot) snapshot);
        WorkingRangePools.a(a);
        WorkingRangePools.a(a2);
        WorkingRangePools.a(this.f11137e);
        this.f11137e = workingRangeBounds;
    }

    private void m16458a(WorkingRangeBounds workingRangeBounds, HashSet<Item> hashSet, Snapshot snapshot) {
        if (!workingRangeBounds.m16471e()) {
            int i = workingRangeBounds.f11142e;
            for (int i2 = workingRangeBounds.f11141d; i2 <= i; i2++) {
                Object a = snapshot.a(i2);
                if (!m16460a(a)) {
                    hashSet.remove(a);
                    if (m16462b(a)) {
                        this.f11134b.size();
                    }
                }
            }
        }
    }

    private void m16457a(@Nullable WorkingRangeBounds workingRangeBounds, Snapshot snapshot) {
        if (workingRangeBounds != null && !workingRangeBounds.m16471e()) {
            int i = workingRangeBounds.f11141d;
            int i2 = workingRangeBounds.f11142e;
            for (int i3 = i; i3 <= i2; i3++) {
                Object a = snapshot.a(i3);
                if (!m16460a(a)) {
                    if (a == null || !this.f11135c.remove(a)) {
                    }
                    int size = this.f11134b.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((BaseWorkingRangeListener) this.f11134b.b(i4)).mo2116a(a, i3, snapshot);
                    }
                }
            }
        }
    }

    private void m16461b(@Nullable WorkingRangeBounds workingRangeBounds, Snapshot snapshot) {
        if (workingRangeBounds != null && !workingRangeBounds.m16471e()) {
            int i = workingRangeBounds.f11142e;
            for (int i2 = workingRangeBounds.f11141d; i2 <= i; i2++) {
                Object a = snapshot.a(i2);
                if (!m16460a(a)) {
                    m16462b(a);
                    this.f11134b.size();
                }
            }
        }
    }

    private static boolean m16460a(Object obj) {
        return obj == null;
    }

    private boolean m16462b(Item item) {
        return item != null && this.f11135c.add(item);
    }
}
