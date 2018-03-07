package com.google.common.collect;

import com.google.common.collect.Sets.SetView;
import java.util.Iterator;
import java.util.Set;

/* compiled from: bug_source */
public final class Sets$4 extends SetView<E> {
    final /* synthetic */ Set f7546a;
    final /* synthetic */ Set f7547b;

    public Sets$4(Set set, Set set2) {
        this.f7546a = set;
        this.f7547b = set2;
    }

    public final Iterator<E> iterator() {
        final Iterator it = this.f7546a.iterator();
        final Iterator it2 = this.f7547b.iterator();
        return new AbstractIterator<E>(this) {
            final /* synthetic */ Sets$4 f7545c;

            public final E m13656a() {
                while (it.hasNext()) {
                    E next = it.next();
                    if (!this.f7545c.f7547b.contains(next)) {
                        return next;
                    }
                }
                while (it2.hasNext()) {
                    next = it2.next();
                    if (!this.f7545c.f7546a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    public final int size() {
        return Iterators.b(iterator());
    }

    public final boolean isEmpty() {
        return this.f7546a.equals(this.f7547b);
    }

    public final boolean contains(Object obj) {
        return this.f7546a.contains(obj) ^ this.f7547b.contains(obj);
    }
}
