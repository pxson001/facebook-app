package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

/* compiled from: square_profile_pic_size_big */
public final class ArrayBuilders {
    private BooleanBuilder f4191a = null;
    private ByteBuilder f4192b = null;
    private ShortBuilder f4193c = null;
    private IntBuilder f4194d = null;
    private LongBuilder f4195e = null;
    private FloatBuilder f4196f = null;
    private DoubleBuilder f4197g = null;

    public final BooleanBuilder m7774a() {
        if (this.f4191a == null) {
            this.f4191a = new BooleanBuilder();
        }
        return this.f4191a;
    }

    public final ByteBuilder m7775b() {
        if (this.f4192b == null) {
            this.f4192b = new ByteBuilder();
        }
        return this.f4192b;
    }

    public final ShortBuilder m7776c() {
        if (this.f4193c == null) {
            this.f4193c = new ShortBuilder();
        }
        return this.f4193c;
    }

    public final IntBuilder m7777d() {
        if (this.f4194d == null) {
            this.f4194d = new IntBuilder();
        }
        return this.f4194d;
    }

    public final LongBuilder m7778e() {
        if (this.f4195e == null) {
            this.f4195e = new LongBuilder();
        }
        return this.f4195e;
    }

    public final FloatBuilder m7779f() {
        if (this.f4196f == null) {
            this.f4196f = new FloatBuilder();
        }
        return this.f4196f;
    }

    public final DoubleBuilder m7780g() {
        if (this.f4197g == null) {
            this.f4197g = new DoubleBuilder();
        }
        return this.f4197g;
    }

    public static Object m7769a(Object obj) {
        return new 1(obj.getClass(), Array.getLength(obj), obj);
    }

    public static <T> HashSet<T> m7771a(T[] tArr) {
        HashSet<T> hashSet = new HashSet();
        if (tArr != null) {
            for (Object add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> HashSet<T> m7770a(Set<T> set, T[] tArr) {
        HashSet<T> hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        if (tArr != null) {
            for (Object add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> T[] m7772a(T[] tArr, T t) {
        Object[] objArr;
        int length = tArr.length;
        int i = 0;
        while (i < length) {
            if (tArr[i] != t) {
                i++;
            } else if (i == 0) {
                return tArr;
            } else {
                objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length);
                System.arraycopy(tArr, 0, objArr, 1, i);
                objArr[0] = t;
                i++;
                int i2 = length - i;
                if (i2 <= 0) {
                    return objArr;
                }
                System.arraycopy(tArr, i, objArr, i, i2);
                return objArr;
            }
        }
        objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + 1);
        if (length > 0) {
            System.arraycopy(tArr, 0, objArr, 1, length);
        }
        objArr[0] = t;
        return objArr;
    }

    public static <T> Iterable<T> m7773b(T[] tArr) {
        return new ArrayIterator(tArr);
    }
}
