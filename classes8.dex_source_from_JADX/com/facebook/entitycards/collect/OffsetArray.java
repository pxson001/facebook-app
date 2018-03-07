package com.facebook.entitycards.collect;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: index must be in range of states */
public class OffsetArray<T> {
    private final List<T> f10899a;
    private int f10900b;

    public OffsetArray(int i) {
        this(i, new ArrayList());
    }

    protected OffsetArray(int i, List<T> list) {
        this.f10899a = list;
        this.f10900b = i;
    }

    public final synchronized int m12835a(int i) {
        return this.f10900b + i;
    }

    public final synchronized T m12839b(int i) {
        return this.f10899a.get(i);
    }

    public final synchronized int m12838b() {
        return this.f10899a.size();
    }

    public final synchronized boolean m12840c() {
        return this.f10899a.isEmpty();
    }

    public synchronized void mo771a(int i, T t) {
        if (m12841c(i)) {
            int i2 = i - this.f10900b;
            if (i2 == -1) {
                this.f10899a.add(0, t);
                this.f10900b--;
            } else if (i2 == this.f10899a.size()) {
                this.f10899a.add(this.f10899a.size(), t);
            } else {
                this.f10899a.set(i2, t);
            }
        } else {
            throw new IllegalArgumentException(StringFormatUtil.a("Adding a value at %d would cause a discontinuity in the array", new Object[]{Integer.valueOf(i)}));
        }
    }

    public final synchronized boolean m12841c(int i) {
        boolean z;
        int i2 = i - this.f10900b;
        z = i2 >= -1 && i2 <= this.f10899a.size();
        return z;
    }

    public final synchronized boolean m12837a(T t) {
        return this.f10899a.contains(t);
    }

    public final synchronized ImmutableList<T> m12842d() {
        ImmutableList<T> immutableList;
        if (this.f10899a instanceof ImmutableList) {
            immutableList = (ImmutableList) this.f10899a;
        } else {
            immutableList = ImmutableList.copyOf(this.f10899a);
        }
        return immutableList;
    }
}
