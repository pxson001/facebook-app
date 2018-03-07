package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Array;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_time_to_initial */
public final class ObjectArrays {
    static final Object[] f315a = new Object[0];

    private ObjectArrays() {
    }

    @GwtIncompatible("Array.newInstance(Class, int)")
    public static <T> T[] m626a(Class<T> cls, int i) {
        return (Object[]) Array.newInstance(cls, i);
    }

    public static <T> T[] m628a(@Nullable T t, T[] tArr) {
        Object a = Platform.m648a((Object[]) tArr, tArr.length + 1);
        a[0] = t;
        System.arraycopy(tArr, 0, a, 1, tArr.length);
        return a;
    }

    public static <T> T[] m632a(T[] tArr, @Nullable T t) {
        T[] b = m633b(tArr, tArr.length + 1);
        b[tArr.length] = t;
        return b;
    }

    static <T> T[] m633b(T[] tArr, int i) {
        Object a = Platform.m648a((Object[]) tArr, i);
        System.arraycopy(tArr, 0, a, 0, Math.min(tArr.length, i));
        return a;
    }

    static <T> T[] m630a(Collection<?> collection, T[] tArr) {
        Object[] a;
        int size = collection.size();
        if (tArr.length < size) {
            a = Platform.m648a((Object[]) tArr, size);
        }
        m627a((Iterable) collection, a);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    static Object[] m629a(Collection<?> collection) {
        return m627a((Iterable) collection, new Object[collection.size()]);
    }

    private static Object[] m627a(Iterable<?> iterable, Object[] objArr) {
        int i = 0;
        for (Object obj : iterable) {
            int i2 = i + 1;
            objArr[i] = obj;
            i = i2;
        }
        return objArr;
    }

    static void m625a(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    static Object[] m631a(Object... objArr) {
        return m634c(objArr, objArr.length);
    }

    static Object[] m634c(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            m624a(objArr[i2], i2);
        }
        return objArr;
    }

    static Object m624a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
