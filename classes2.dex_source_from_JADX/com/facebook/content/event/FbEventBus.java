package com.facebook.content.event;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.annotation.Nullable;

/* compiled from: totalLoadTime */
public class FbEventBus<T extends FbEventSubscriber, E extends FbEvent> {
    private final Map<Class<E>, List<WeakReference<T>>> f2389a = Maps.m838c();
    private final Queue<E> f2390b = Queues.m2122a();

    public final synchronized boolean m4568a(T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            Class a = t.mo648a();
            if (this.f2389a.get(a) == null) {
                this.f2389a.put(a, Lists.m1296a());
            }
            List list = (List) this.f2389a.get(a);
            m4564a(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((WeakReference) list.get(i)).get() == t) {
                    z = false;
                    break;
                }
            }
            z = list.add(new WeakReference(t));
        }
        return z;
    }

    public final synchronized boolean m4569b(@Nullable T t) {
        boolean z;
        if (t == null) {
            z = false;
        } else {
            List list = (List) this.f2389a.get(t.mo648a());
            if (list == null) {
                z = false;
            } else {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (((WeakReference) list.get(i)).get() == t) {
                        ((WeakReference) list.get(i)).clear();
                        z = true;
                        break;
                    }
                }
                z = false;
            }
        }
        return z;
    }

    public synchronized void mo651a(E e) {
        if (this.f2390b.isEmpty()) {
            this.f2390b.add(e);
            while (!this.f2390b.isEmpty()) {
                m4565b((FbEvent) this.f2390b.peek());
                this.f2390b.remove();
            }
        } else {
            this.f2390b.add(e);
        }
    }

    private void m4565b(E e) {
        if (this.f2389a != null) {
            Collection collection = (List) this.f2389a.get(e.getClass());
            if (collection != null) {
                m4564a((List) collection);
                if (!collection.isEmpty()) {
                    for (WeakReference weakReference : ImmutableList.copyOf(collection)) {
                        FbEventSubscriber fbEventSubscriber = (FbEventSubscriber) weakReference.get();
                        if (fbEventSubscriber != null && fbEventSubscriber.m4560a(e)) {
                            fbEventSubscriber.mo650b(e);
                        }
                    }
                }
            }
        }
    }

    public final synchronized void m4567a(Class<? extends E> cls) {
        if (this.f2389a != null) {
            List list = (List) this.f2389a.get(cls);
            if (list != null) {
                list.clear();
            }
        }
    }

    @VisibleForTesting
    private static void m4564a(List<WeakReference<T>> list) {
        if (list != null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                WeakReference weakReference = (WeakReference) list.get(i2);
                if (weakReference.get() != null) {
                    int i3 = i + 1;
                    list.set(i, weakReference);
                    i = i3;
                }
            }
            for (int size = list.size() - 1; size >= i; size--) {
                list.remove(size);
            }
        }
    }
}
