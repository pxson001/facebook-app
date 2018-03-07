package com.facebook.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: uncategorized */
public class RingBuffer<T> {
    private final T[] f1992a;
    private int f1993b = 0;
    private int f1994c = 0;
    private int f1995d = 0;

    public RingBuffer(int i) {
        this.f1992a = new Object[i];
    }

    public final synchronized void m4065a(T t) {
        if (m4067c() && !m4062f()) {
            m4063a();
        }
        Preconditions.checkState(this.f1993b < this.f1992a.length, "Overflow");
        this.f1992a[this.f1995d] = t;
        this.f1995d = (this.f1995d + 1) % this.f1992a.length;
        this.f1993b++;
    }

    public final synchronized T m4063a() {
        T t;
        Preconditions.checkState(this.f1993b > 0, "Underflow");
        t = this.f1992a[this.f1994c];
        this.f1992a[this.f1994c] = null;
        this.f1994c = (this.f1994c + 1) % this.f1992a.length;
        this.f1993b--;
        return t;
    }

    public final synchronized T m4064a(int i) {
        if (this.f1993b <= i) {
            throw new IndexOutOfBoundsException();
        }
        return this.f1992a[(this.f1994c + i) % this.f1992a.length];
    }

    public final synchronized List<T> m4066b() {
        List<T> a;
        a = Lists.m1297a(m4068d());
        for (int i = 0; i < this.f1993b; i++) {
            a.add(m4064a(i));
        }
        return a;
    }

    private synchronized boolean m4062f() {
        return this.f1993b == 0;
    }

    public final synchronized boolean m4067c() {
        return this.f1993b == this.f1992a.length;
    }

    public final synchronized int m4068d() {
        return this.f1993b;
    }

    public final synchronized void m4069e() {
        synchronized (this) {
            this.f1993b = 0;
            this.f1994c = 0;
            this.f1995d = 0;
            for (int i = 0; i < this.f1992a.length; i++) {
                this.f1992a[i] = null;
            }
        }
    }
}
