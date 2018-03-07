package com.facebook.entitycards.collect;

import com.google.common.collect.ImmutableList;

/* compiled from: include_in_byline */
public class ImmutableOffsetArray<T> extends OffsetArray<T> {
    public static final ImmutableOffsetArray f10901a;
    private boolean f10902b = false;

    static {
        ImmutableOffsetArray immutableOffsetArray = new ImmutableOffsetArray(0);
        f10901a = immutableOffsetArray;
        immutableOffsetArray.m12844a();
    }

    public static <T> ImmutableOffsetArray<T> m12843a(int i, ImmutableList<T> immutableList) {
        ImmutableOffsetArray<T> immutableOffsetArray = new ImmutableOffsetArray(i, immutableList);
        immutableOffsetArray.m12844a();
        return immutableOffsetArray;
    }

    public ImmutableOffsetArray(int i) {
        super(i);
    }

    private ImmutableOffsetArray(int i, ImmutableList<T> immutableList) {
        super(i, immutableList);
    }

    public final void m12844a() {
        this.f10902b = true;
    }

    public final void mo771a(int i, T t) {
        if (this.f10902b) {
            throw new UnsupportedOperationException();
        }
        super.mo771a(i, t);
    }
}
