package com.facebook.inject;

import com.google.inject.Key;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: delayed_delivery_time_for_display */
public class MultiBinding<T> {
    private final Key<T> f5150a;
    public final ArrayListSet<Key<? extends T>> f5151b = new ArrayListSet();

    /* compiled from: delayed_delivery_time_for_display */
    class ArrayListSet<T> extends ArrayList<T> implements Set<T> {
        public boolean add(T t) {
            return !contains(t) && super.add(t);
        }
    }

    public MultiBinding(Key<T> key) {
        this.f5150a = key;
    }
}
