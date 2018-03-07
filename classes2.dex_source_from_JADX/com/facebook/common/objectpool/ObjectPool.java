package com.facebook.common.objectpool;

import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import java.lang.reflect.Array;

/* compiled from: zero_rating2/clearable/code_pairs */
public class ObjectPool<T> {
    public static final Class<?> f521a = ObjectPool.class;
    private final Class<T> f522b;
    private final int f523c;
    private final int f524d;
    private final int f525e;
    private final Allocator<T> f526f;
    private final MonotonicClock f527g;
    private final long f528h;
    private long f529i;
    private T[] f530j = ((Object[]) Array.newInstance(this.f522b, this.f523c));
    private int f531k;

    /* compiled from: zero_rating2/clearable/code_pairs */
    public class BasicAllocator<T> implements Allocator<T> {
        Class<T> f520a;

        public BasicAllocator(Class<T> cls) {
            this.f520a = cls;
        }

        public T mo86a() {
            try {
                return this.f520a.newInstance();
            } catch (Throwable e) {
                BLog.b(ObjectPool.f521a, "Couldn't instantiate object", e);
                return null;
            } catch (Throwable e2) {
                BLog.b(ObjectPool.f521a, "Couldn't instantiate object", e2);
                return null;
            }
        }

        public void mo87a(T t) {
        }
    }

    /* compiled from: zero_rating2/clearable/code_pairs */
    public interface Allocator<T> {
        T mo86a();

        void mo87a(T t);
    }

    public ObjectPool(Class<T> cls, int i, int i2, int i3, long j, Allocator<T> allocator, MonotonicClock monotonicClock) {
        this.f522b = cls;
        this.f523c = Math.max(i, 0);
        this.f524d = Math.max(this.f523c, i2);
        this.f525e = Math.max(i3, 1);
        this.f528h = j;
        this.f526f = allocator;
        this.f527g = monotonicClock;
    }

    public final synchronized T m1057a() {
        T t;
        if (this.f531k > 0) {
            this.f531k--;
            t = this.f530j[this.f531k];
            this.f530j[this.f531k] = null;
        } else {
            t = this.f526f.mo86a();
        }
        return t;
    }

    public final synchronized void m1058a(T t) {
        m1055c();
        this.f526f.mo87a(t);
        if (this.f531k < this.f524d) {
            if (this.f531k + 1 > this.f530j.length) {
                m1054a(Math.min(this.f524d, this.f530j.length + this.f525e));
            }
            Object[] objArr = this.f530j;
            int i = this.f531k;
            this.f531k = i + 1;
            objArr[i] = t;
        }
    }

    private synchronized void m1055c() {
        long now = this.f527g.now();
        if (this.f531k < this.f525e * 2) {
            this.f529i = now;
        }
        if (now - this.f529i > this.f528h) {
            m1056d();
        }
    }

    private synchronized void m1056d() {
        int max = Math.max(this.f530j.length - this.f525e, this.f523c);
        if (max != this.f530j.length) {
            m1054a(max);
        }
    }

    private void m1054a(int i) {
        Object[] objArr = (Object[]) Array.newInstance(this.f522b, i);
        System.arraycopy(this.f530j, 0, objArr, 0, Math.min(this.f530j.length, i));
        this.f530j = objArr;
        this.f531k = Math.min(this.f531k, i);
    }
}
