package com.facebook.katana.util;

import java.lang.ref.WeakReference;

/* compiled from: p2p_initiate_reset_pin */
public class WeakRef<T> extends WeakReference<T> {
    public WeakRef(T t) {
        super(t);
    }

    public int hashCode() {
        Object obj = get();
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WeakRef)) {
            return false;
        }
        WeakRef weakRef = (WeakRef) obj;
        Object obj2 = get();
        Object obj3 = weakRef.get();
        if (obj2 == null || obj3 == null) {
            return false;
        }
        return obj2.equals(obj3);
    }
}
