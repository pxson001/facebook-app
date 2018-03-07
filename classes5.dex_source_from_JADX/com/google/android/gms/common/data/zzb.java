package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> f6486a;
    protected int f6487b = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f6486a = (DataBuffer) zzx.a(dataBuffer);
    }

    public boolean hasNext() {
        return this.f6487b < this.f6486a.mo735a() + -1;
    }

    public T next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.f6486a;
            int i = this.f6487b + 1;
            this.f6487b = i;
            return dataBuffer.mo739a(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f6487b);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
