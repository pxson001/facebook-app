package com.facebook.common.listeners;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: viewer_guest_status */
public abstract class AbstractWeakListenersManager<K, A, T> {
    private final WeakHashMap<T, Set<K>> f1040a = new WeakHashMap();

    public abstract void mo325a(T t, A a, K k);

    public final synchronized void m2115a(K k, T t) {
        boolean z = true;
        synchronized (this) {
            Preconditions.m2017b(k != null);
            if (t == null) {
                z = false;
            }
            Preconditions.m2017b(z);
            Set set = (Set) this.f1040a.get(t);
            if (set == null) {
                set = new HashSet(4);
            }
            set.add(k);
            this.f1040a.put(t, set);
        }
    }

    public final synchronized void m2120b(K k, T t) {
        boolean z = true;
        synchronized (this) {
            Preconditions.m2017b(k != null);
            if (t == null) {
                z = false;
            }
            Preconditions.m2017b(z);
            Set set = (Set) this.f1040a.get(t);
            if (set != null) {
                set.remove(k);
                if (set.isEmpty()) {
                    this.f1040a.remove(t);
                }
            }
        }
    }

    public final synchronized void m2117a(Collection<K> collection, T t) {
        Preconditions.m2017b(t != null);
        Object obj = (Set) this.f1040a.get(t);
        if (obj == null) {
            obj = new HashSet(collection);
        } else {
            obj.addAll(collection);
        }
        this.f1040a.put(t, obj);
    }

    protected boolean mo326a(Set<K> set, K k) {
        return set.contains(k);
    }

    private synchronized boolean m2113b(Collection<K> collection) {
        boolean z;
        loop0:
        for (Object next : collection) {
            for (Entry value : this.f1040a.entrySet()) {
                if (mo326a((Set) value.getValue(), next)) {
                    z = true;
                    break loop0;
                }
            }
        }
        z = false;
        return z;
    }

    final synchronized Map<K, Collection<T>> m2114a(Collection<K> collection) {
        Map<K, Collection<T>> map;
        map = null;
        for (Object next : collection) {
            Map<K, Collection<T>> hashMap;
            Collection collection2 = null;
            for (Entry entry : this.f1040a.entrySet()) {
                Collection collection3;
                if (mo326a((Set) entry.getValue(), next)) {
                    Collection hashSet;
                    if (collection2 == null) {
                        hashSet = new HashSet();
                    } else {
                        hashSet = collection2;
                    }
                    hashSet.add(entry.getKey());
                    collection3 = hashSet;
                } else {
                    collection3 = collection2;
                }
                collection2 = collection3;
            }
            if (collection2 != null) {
                if (map == null) {
                    hashMap = new HashMap();
                } else {
                    hashMap = map;
                }
                hashMap.put(next, collection2);
            } else {
                hashMap = map;
            }
            map = hashMap;
        }
        return map;
    }

    public final void m2118a(final Collection<K> collection, final A a, Executor executor) {
        if (m2113b(collection)) {
            ExecutorDetour.a(executor, new Runnable(this) {
                final /* synthetic */ AbstractWeakListenersManager f23507c;

                public void run() {
                    Map a = this.f23507c.m2114a(collection);
                    if (a != null) {
                        AbstractWeakListenersManager abstractWeakListenersManager = this.f23507c;
                        Object obj = a;
                        for (Entry entry : a.entrySet()) {
                            for (Object a2 : (Collection) entry.getValue()) {
                                abstractWeakListenersManager.mo325a(a2, obj, entry.getKey());
                            }
                        }
                    }
                }
            }, -1947045230);
        }
    }
}
