package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

/* compiled from: thread_id_canonical */
class Lists$Partition<T> extends AbstractList<List<T>> {
    final List<T> f1189a;
    final int f1190b;

    Lists$Partition(List<T> list, int i) {
        this.f1189a = list;
        this.f1190b = i;
    }

    public Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        int i2 = this.f1190b * i;
        return this.f1189a.subList(i2, Math.min(this.f1190b + i2, this.f1189a.size()));
    }

    public int size() {
        return IntMath.a(this.f1189a.size(), this.f1190b, RoundingMode.CEILING);
    }

    public boolean isEmpty() {
        return this.f1189a.isEmpty();
    }
}
