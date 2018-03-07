package com.facebook.backstage.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: responderIgnoreScroll */
public class OptimisticMediaItemStoreHelper<T extends MediaItem> {
    private final Map<String, T> f5135a = new HashMap();
    private final Object f5136b = new Object();

    public final void m4915a(UploadShot uploadShot, T t) {
        synchronized (this.f5136b) {
            this.f5135a.put(uploadShot.m4920a(), t);
        }
    }

    public final Collection<T> m4913a() {
        Collection<T> values;
        synchronized (this.f5136b) {
            values = this.f5135a.values();
        }
        return values;
    }

    public final void m4917a(String str, UploadShot uploadShot) {
        synchronized (this.f5136b) {
            this.f5135a.put(str, (MediaItem) this.f5135a.remove(uploadShot.m4920a()));
        }
    }

    public final void m4914a(UploadShot uploadShot) {
        synchronized (this.f5136b) {
            m4916a(uploadShot.m4920a());
        }
    }

    public final void m4916a(String str) {
        synchronized (this.f5136b) {
            this.f5135a.remove(str);
        }
    }
}
