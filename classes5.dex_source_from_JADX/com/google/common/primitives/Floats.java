package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: bug_report_attachment_did_upload */
public final class Floats {

    @GwtCompatible
    /* compiled from: bug_report_attachment_did_upload */
    public class FloatArrayAsList extends AbstractList<Float> implements Serializable, RandomAccess {
        public final float[] array;
        final int end;
        public final int start;

        public Object set(int i, Object obj) {
            Float f = (Float) obj;
            Preconditions.checkElementIndex(i, size());
            float f2 = this.array[this.start + i];
            this.array[this.start + i] = ((Float) Preconditions.checkNotNull(f)).floatValue();
            return Float.valueOf(f2);
        }

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        private FloatArrayAsList(float[] fArr, int i, int i2) {
            this.array = fArr;
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
            return Float.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.m13820c(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Float) {
                int c = Floats.m13820c(this.array, ((Float) obj).floatValue(), this.start, this.end);
                if (c >= 0) {
                    return c - this.start;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                float[] fArr = this.array;
                float floatValue = ((Float) obj).floatValue();
                int i = this.start;
                int i2 = this.end - 1;
                while (i2 >= i) {
                    if (fArr[i2] == floatValue) {
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

        public List<Float> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new FloatArrayAsList(this.array, this.start + i, this.start + i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != floatArrayAsList.array[floatArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Float.valueOf(this.array[i2]).hashCode();
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size() * 12);
            stringBuilder.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; i++) {
                stringBuilder.append(", ").append(this.array[i]);
            }
            return stringBuilder.append(']').toString();
        }
    }

    private Floats() {
    }

    public static int m13820c(float[] fArr, float f, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (fArr[i3] == f) {
                return i3;
            }
        }
        return -1;
    }

    public static float[] m13819a(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) collection;
            int size = floatArrayAsList.size();
            Object obj = new float[size];
            System.arraycopy(floatArrayAsList.array, floatArrayAsList.start, obj, 0, size);
            return obj;
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            fArr[i] = ((Number) Preconditions.checkNotNull(toArray[i])).floatValue();
        }
        return fArr;
    }
}
