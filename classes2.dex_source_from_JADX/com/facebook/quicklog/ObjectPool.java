package com.facebook.quicklog;

/* compiled from: zero_rating2/clearable/code_pairs */
abstract class ObjectPool<T extends Poolable<T>> {
    private T f2280a = null;
    private int f2281b = 0;
    private int f2282c = 0;
    private int f2283d = 0;
    private int f2284e = 0;
    private final int f2285f;

    /* compiled from: zero_rating2/clearable/code_pairs */
    interface Poolable<P> {
        P mo79a();

        void mo80a(P p);

        void mo81b();
    }

    abstract T mo642a();

    ObjectPool(int i) {
        this.f2285f = i;
    }

    public final synchronized T m4469b() {
        T a;
        this.f2283d++;
        if (this.f2280a == null) {
            this.f2281b++;
            a = mo642a();
        } else {
            T t = this.f2280a;
            this.f2280a = (Poolable) t.mo79a();
            t.mo81b();
            this.f2282c--;
            a = t;
        }
        return a;
    }

    public final synchronized void m4468a(T t) {
        this.f2284e++;
        if (this.f2282c < this.f2285f) {
            t.mo80a(this.f2280a);
            this.f2280a = t;
            this.f2282c++;
        }
    }
}
