package com.facebook.common.collect;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: share_type */
public class ReentrantCallback<CallbackClass> implements Iterable<CallbackClass> {
    private final Set<CallbackClass> f4974a = new HashSet();
    private Set<CallbackClass> f4975b = null;

    public final synchronized Set<CallbackClass> m8893a() {
        if (this.f4975b == null) {
            this.f4975b = ImmutableSet.copyOf(this.f4974a);
        }
        return this.f4975b;
    }

    public synchronized Iterator<CallbackClass> iterator() {
        if (this.f4975b == null) {
            this.f4975b = ImmutableSet.copyOf(this.f4974a);
        }
        return this.f4975b.iterator();
    }

    public final synchronized void m8894a(CallbackClass callbackClass) {
        this.f4974a.add(callbackClass);
        this.f4975b = null;
    }

    public final synchronized void m8896b(CallbackClass callbackClass) {
        this.f4974a.remove(callbackClass);
        this.f4975b = null;
    }

    public final synchronized void m8895b() {
        this.f4974a.clear();
        this.f4975b = null;
    }
}
