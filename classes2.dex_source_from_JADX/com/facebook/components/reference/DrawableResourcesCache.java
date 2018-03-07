package com.facebook.components.reference;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.support.v4.util.Pools$SynchronizedPool;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: full_power_time */
public class DrawableResourcesCache {
    public final LruCache<Integer, SimplePoolWithCount<Drawable>> f22861a = new LruCache<Integer, SimplePoolWithCount<Drawable>>(this, 200) {
        final /* synthetic */ DrawableResourcesCache f22862a;

        protected final int mo3292b(Object obj, Object obj2) {
            return ((SimplePoolWithCount) obj2).m31138b();
        }
    };

    /* compiled from: full_power_time */
    public class SimplePoolWithCount<T> extends Pools$SynchronizedPool<T> {
        private AtomicInteger f23009a = new AtomicInteger(0);

        public SimplePoolWithCount(int i) {
            super(i);
        }

        public final T mo740a() {
            T a = super.mo740a();
            if (a != null) {
                this.f23009a.decrementAndGet();
            }
            return a;
        }

        public final boolean mo741a(T t) {
            boolean a = super.mo741a(t);
            if (a) {
                this.f23009a.incrementAndGet();
            }
            return a;
        }

        public final int m31138b() {
            return this.f23009a.get();
        }
    }

    DrawableResourcesCache() {
    }
}
