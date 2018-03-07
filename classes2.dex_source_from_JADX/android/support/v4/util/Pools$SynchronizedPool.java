package android.support.v4.util;

/* compiled from: tap_profile_pic */
public class Pools$SynchronizedPool<T> extends Pools$SimplePool<T> {
    private final Object f3232a = new Object();

    public Pools$SynchronizedPool(int i) {
        super(i);
    }

    public T mo740a() {
        T a;
        synchronized (this.f3232a) {
            a = super.mo740a();
        }
        return a;
    }

    public boolean mo741a(T t) {
        boolean a;
        synchronized (this.f3232a) {
            a = super.mo741a(t);
        }
        return a;
    }
}
