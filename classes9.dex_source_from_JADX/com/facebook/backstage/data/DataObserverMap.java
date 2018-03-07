package com.facebook.backstage.data;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: result is null. */
public class DataObserverMap<T> {
    private final Map<Integer, WeakReference<T>> f5119a = new HashMap();
    private final Object f5120b = new Object();

    public final void m4902a(T t) {
        synchronized (this.f5120b) {
            this.f5119a.put(Integer.valueOf(t.hashCode()), new WeakReference(t));
        }
    }

    public final void m4903b(T t) {
        synchronized (this.f5120b) {
            this.f5119a.remove(Integer.valueOf(t.hashCode()));
        }
    }

    public final List<WeakReference<T>> m4901a() {
        List<WeakReference<T>> arrayList = new ArrayList();
        synchronized (this.f5120b) {
            for (WeakReference add : this.f5119a.values()) {
                arrayList.add(add);
            }
        }
        return arrayList;
    }
}
