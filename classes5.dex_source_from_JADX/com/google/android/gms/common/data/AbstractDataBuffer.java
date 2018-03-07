package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    public final DataHolder f6461a;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.f6461a = dataHolder;
        if (this.f6461a != null) {
            this.f6461a.f6484j = this;
        }
    }

    public int mo735a() {
        return this.f6461a == null ? 0 : this.f6461a.f6477c;
    }

    @Deprecated
    public final void mo736b() {
        mo737c();
    }

    public final void mo737c() {
        if (this.f6461a != null) {
            this.f6461a.m12171h();
        }
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }
}
