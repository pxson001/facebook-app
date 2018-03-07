package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible
/* compiled from: camera_flash_mode */
final class LongAdder extends Striped64 implements LongAddable, Serializable {
    final long mo876a(long j, long j2) {
        return j + j2;
    }

    public final void mo875a(long j) {
        Cell[] cellArr = this.f7246d;
        if (cellArr == null) {
            long j2 = this.f7247e;
            if (m13183b(j2, j2 + j)) {
                return;
            }
        }
        boolean z = true;
        int[] iArr = (int[]) Striped64.f7240a.get();
        if (!(iArr == null || cellArr == null)) {
            int length = cellArr.length;
            if (length > 0) {
                Cell cell = cellArr[(length - 1) & iArr[0]];
                if (cell != null) {
                    long j3 = cell.f7254a;
                    z = cell.m13188a(j3, j3 + j);
                    if (z) {
                        return;
                    }
                }
            }
        }
        m13182a(j, iArr, z);
    }

    public final void mo874a() {
        mo875a(1);
    }

    private long m13184c() {
        long j = this.f7247e;
        Cell[] cellArr = this.f7246d;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    j += cell.f7254a;
                }
            }
        }
        return j;
    }

    public final String toString() {
        return Long.toString(m13184c());
    }

    public final long longValue() {
        return m13184c();
    }

    public final int intValue() {
        return (int) m13184c();
    }

    public final float floatValue() {
        return (float) m13184c();
    }

    public final double doubleValue() {
        return (double) m13184c();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(m13184c());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f = 0;
        this.d = null;
        this.e = objectInputStream.readLong();
    }
}
