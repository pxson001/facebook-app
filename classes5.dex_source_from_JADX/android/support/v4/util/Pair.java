package android.support.v4.util;

/* compiled from: video_status_type */
public class Pair<F, S> {
    public final F f270a;
    public final S f271b;

    public Pair(F f, S s) {
        this.f270a = f;
        this.f271b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (m290b(pair.f270a, this.f270a) && m290b(pair.f271b, this.f271b)) {
            return true;
        }
        return false;
    }

    private static boolean m290b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f270a == null ? 0 : this.f270a.hashCode();
        if (this.f271b != null) {
            i = this.f271b.hashCode();
        }
        return hashCode ^ i;
    }

    public static <A, B> Pair<A, B> m289a(A a, B b) {
        return new Pair(a, b);
    }
}
