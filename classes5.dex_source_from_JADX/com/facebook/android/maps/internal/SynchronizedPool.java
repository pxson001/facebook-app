package com.facebook.android.maps.internal;

import android.graphics.Bitmap;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import java.util.Vector;

/* compiled from: autofriend_parent_kid */
public class SynchronizedPool<T> {
    private static final Vector<SynchronizedPool> f8481a = new Vector();
    private final Object[] f8482b;
    private int f8483c;

    /* compiled from: autofriend_parent_kid */
    final class C09311 extends Dispatchable {
        C09311() {
        }

        public final void run() {
            SynchronizedPool.m14512a();
        }
    }

    public static void m14512a() {
        synchronized (f8481a) {
            int size = f8481a.size();
            for (int i = 0; i < size; i++) {
                ((SynchronizedPool) f8481a.get(i)).m14517d();
            }
        }
    }

    public static void m14513b() {
        GrandCentralDispatch.a(new C09311());
    }

    public SynchronizedPool(int i) {
        this.f8482b = new Object[i];
        f8481a.add(this);
    }

    public final synchronized T m14516c() {
        T t = null;
        synchronized (this) {
            if (this.f8483c > 0) {
                int i = this.f8483c - 1;
                t = this.f8482b[i];
                this.f8482b[i] = null;
                this.f8483c--;
            }
        }
        return t;
    }

    public final synchronized boolean m14515a(T t) {
        boolean z;
        if (m14514b(t) || this.f8483c >= this.f8482b.length) {
            z = false;
        } else {
            this.f8482b[this.f8483c] = t;
            this.f8483c++;
            z = true;
        }
        return z;
    }

    public final synchronized void m14517d() {
        int length = this.f8482b.length;
        for (int i = 0; i < length; i++) {
            Object obj = this.f8482b[i];
            if (obj != null && (obj instanceof Bitmap)) {
                ((Bitmap) obj).recycle();
            }
            this.f8482b[i] = null;
        }
        this.f8483c = 0;
    }

    private boolean m14514b(T t) {
        for (int i = 0; i < this.f8483c; i++) {
            if (this.f8482b[i] == t) {
                return true;
            }
        }
        return false;
    }
}
