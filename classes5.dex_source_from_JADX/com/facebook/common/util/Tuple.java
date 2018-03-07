package com.facebook.common.util;

import javax.annotation.Nullable;

/* compiled from: sponsor_page */
public class Tuple<T0, T1> {
    public final T0 f2591a;
    public final T1 f2592b;

    public static <T0, T1> Tuple<T0, T1> m3696a(T0 t0, T1 t1) {
        return new Tuple(t0, t1);
    }

    public Tuple(@Nullable T0 t0, @Nullable T1 t1) {
        this.f2591a = t0;
        this.f2592b = t1;
    }

    public int hashCode() {
        int i = 0;
        if (this.f2591a != null) {
            i = this.f2591a.hashCode() ^ 0;
        }
        if (this.f2592b != null) {
            return i ^ this.f2592b.hashCode();
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tuple)) {
            return false;
        }
        Tuple tuple = (Tuple) obj;
        if (this.f2591a != tuple.f2591a && this.f2591a != null && !this.f2591a.equals(tuple.f2591a)) {
            return false;
        }
        if (this.f2592b == tuple.f2592b || this.f2592b == null || this.f2592b.equals(tuple.f2592b)) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = "<";
        if (this.f2591a != null) {
            str = str + this.f2591a;
        }
        str = str + ":";
        if (this.f2592b != null) {
            str = str + this.f2592b;
        }
        return str + ">";
    }
}
