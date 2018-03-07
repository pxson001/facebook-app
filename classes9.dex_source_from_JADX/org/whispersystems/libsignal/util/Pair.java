package org.whispersystems.libsignal.util;

/* compiled from: acquisition */
public class Pair<T1, T2> {
    public final T1 f21480a;
    public final T2 f21481b;

    public Pair(T1 t1, T2 t2) {
        this.f21480a = t1;
        this.f21481b = t2;
    }

    public final T1 m22415a() {
        return this.f21480a;
    }

    public int hashCode() {
        return this.f21480a.hashCode() ^ this.f21481b.hashCode();
    }

    public final T2 m22416b() {
        return this.f21481b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Pair) && m22414a(((Pair) obj).f21480a, this.f21480a) && m22414a(((Pair) obj).f21481b, this.f21481b);
    }

    private static boolean m22414a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}
