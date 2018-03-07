package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_report */
public class Longs$LongArrayAsList extends AbstractList<Long> implements Serializable, RandomAccess {
    public final long[] array;
    final int end;
    public final int start;

    public Object set(int i, Object obj) {
        Long l = (Long) obj;
        Preconditions.checkElementIndex(i, size());
        long j = this.array[this.start + i];
        this.array[this.start + i] = ((Long) Preconditions.checkNotNull(l)).longValue();
        return Long.valueOf(j);
    }

    Longs$LongArrayAsList(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    private Longs$LongArrayAsList(long[] jArr, int i, int i2) {
        this.array = jArr;
        this.start = i;
        this.end = i2;
    }

    public int size() {
        return this.end - this.start;
    }

    public boolean isEmpty() {
        return false;
    }

    public Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        return Long.valueOf(this.array[this.start + i]);
    }

    public boolean contains(Object obj) {
        return (obj instanceof Long) && Longs.c(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
    }

    public int indexOf(Object obj) {
        if (obj instanceof Long) {
            int c = Longs.c(this.array, ((Long) obj).longValue(), this.start, this.end);
            if (c >= 0) {
                return c - this.start;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj instanceof Long) {
            long[] jArr = this.array;
            long longValue = ((Long) obj).longValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (i2 >= i) {
                if (jArr[i2] == longValue) {
                    break;
                }
                i2--;
            }
            i2 = -1;
            int i3 = i2;
            if (i3 >= 0) {
                return i3 - this.start;
            }
        }
        return -1;
    }

    public List<Long> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        return new Longs$LongArrayAsList(this.array, this.start + i, this.start + i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Longs$LongArrayAsList)) {
            return super.equals(obj);
        }
        Longs$LongArrayAsList longs$LongArrayAsList = (Longs$LongArrayAsList) obj;
        int size = size();
        if (longs$LongArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != longs$LongArrayAsList.array[longs$LongArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i *= 31;
            long j = this.array[i2];
            i += (int) ((j >>> 32) ^ j);
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(size() * 10);
        stringBuilder.append('[').append(this.array[this.start]);
        for (int i = this.start + 1; i < this.end; i++) {
            stringBuilder.append(", ").append(this.array[i]);
        }
        return stringBuilder.append(']').toString();
    }
}
