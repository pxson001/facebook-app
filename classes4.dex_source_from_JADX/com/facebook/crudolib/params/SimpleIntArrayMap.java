package com.facebook.crudolib.params;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: fbrpc */
public class SimpleIntArrayMap<K> {
    public Object[] f11936a;
    public int[] f11937b;
    public int f11938c;

    public SimpleIntArrayMap(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Non-positive capacity not allowed");
        }
        this.f11936a = new Object[i];
        this.f11937b = new int[i];
        this.f11938c = 0;
    }

    public final void m12553a(K k, int i) {
        int a = m12552a(k);
        if (a >= 0) {
            this.f11937b[a] = i;
            return;
        }
        a = this.f11938c + 1;
        int length = this.f11936a.length;
        if (length < a) {
            while (length < a) {
                length *= 2;
            }
            Object obj = new Object[length];
            System.arraycopy(this.f11936a, 0, obj, 0, this.f11938c);
            this.f11936a = obj;
            Object obj2 = new int[length];
            System.arraycopy(this.f11937b, 0, obj2, 0, this.f11938c);
            this.f11937b = obj2;
        }
        this.f11936a[this.f11938c] = k;
        this.f11937b[this.f11938c] = i;
        this.f11938c++;
    }

    public final int m12554b(K k, int i) {
        int a = m12552a(k);
        if (a >= 0) {
            return this.f11937b[a];
        }
        return i;
    }

    private int m12552a(K k) {
        for (int i = 0; i < this.f11938c; i++) {
            if (this.f11936a[i].equals(k)) {
                return i;
            }
        }
        return -1;
    }
}
