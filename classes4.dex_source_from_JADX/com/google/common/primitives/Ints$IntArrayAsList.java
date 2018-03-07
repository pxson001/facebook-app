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
/* compiled from: update_check_minutes LIMIT 1 */
public class Ints$IntArrayAsList extends AbstractList<Integer> implements Serializable, RandomAccess {
    public final int[] array;
    final int end;
    public final int start;

    public Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        Preconditions.checkElementIndex(i, size());
        int i2 = this.array[this.start + i];
        this.array[this.start + i] = ((Integer) Preconditions.checkNotNull(num)).intValue();
        return Integer.valueOf(i2);
    }

    private Ints$IntArrayAsList(int[] iArr, int i, int i2) {
        this.array = iArr;
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
        return Integer.valueOf(this.array[this.start + i]);
    }

    public boolean contains(Object obj) {
        return (obj instanceof Integer) && Ints.c(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
    }

    public int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int c = Ints.c(this.array, ((Integer) obj).intValue(), this.start, this.end);
            if (c >= 0) {
                return c - this.start;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.array;
            int intValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = this.end - 1;
            while (i2 >= i) {
                if (iArr[i2] == intValue) {
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

    public List<Integer> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        return new Ints$IntArrayAsList(this.array, this.start + i, this.start + i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ints$IntArrayAsList)) {
            return super.equals(obj);
        }
        Ints$IntArrayAsList ints$IntArrayAsList = (Ints$IntArrayAsList) obj;
        int size = size();
        if (ints$IntArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != ints$IntArrayAsList.array[ints$IntArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(size() * 5);
        stringBuilder.append('[').append(this.array[this.start]);
        for (int i = this.start + 1; i < this.end; i++) {
            stringBuilder.append(", ").append(this.array[i]);
        }
        return stringBuilder.append(']').toString();
    }
}
