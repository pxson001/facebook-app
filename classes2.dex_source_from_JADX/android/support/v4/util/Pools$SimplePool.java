package android.support.v4.util;

/* compiled from: tap_profile_pic */
public class Pools$SimplePool<T> implements Pools$Pool<T> {
    public final Object[] f3233a;
    public int f3234b;

    public Pools$SimplePool(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f3233a = new Object[i];
    }

    public T mo740a() {
        if (this.f3234b <= 0) {
            return null;
        }
        int i = this.f3234b - 1;
        T t = this.f3233a[i];
        this.f3233a[i] = null;
        this.f3234b--;
        return t;
    }

    public boolean mo741a(T t) {
        Object obj = null;
        for (int i = 0; i < this.f3234b; i++) {
            if (this.f3233a[i] == t) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f3234b >= this.f3233a.length) {
            return false;
        } else {
            this.f3233a[this.f3234b] = t;
            this.f3234b++;
            return true;
        }
    }
}
