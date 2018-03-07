package com.facebook.common.collect;

import android.support.v4.util.LongSparseArray;

/* compiled from: messenger_react_native_agents_gk */
public class LongArraySet {
    public LongSparseArray<LongArraySet> f13799a;

    public LongArraySet() {
        this(new LongSparseArray());
    }

    private LongArraySet(int i) {
        this(new LongSparseArray(i));
    }

    private LongArraySet(LongSparseArray<LongArraySet> longSparseArray) {
        this.f13799a = longSparseArray;
    }

    public static LongArraySet m20209a(int i) {
        return new LongArraySet(i);
    }

    public final void m20210a(long j) {
        this.f13799a.m4364b(j, this);
    }

    public final boolean m20211a() {
        return this.f13799a.m4356a() == 0;
    }

    public final long[] m20212b() {
        int a = this.f13799a.m4356a();
        long[] jArr = new long[a];
        for (int i = 0; i < a; i++) {
            jArr[i] = this.f13799a.m4361b(i);
        }
        return jArr;
    }
}
