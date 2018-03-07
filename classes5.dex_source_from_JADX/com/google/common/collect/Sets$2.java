package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets.SetView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: bug_source */
final class Sets$2 extends SetView<E> {
    final /* synthetic */ Set f7540a;
    final /* synthetic */ Predicate f7541b;
    final /* synthetic */ Set f7542c;

    Sets$2(Set set, Predicate predicate, Set set2) {
        this.f7540a = set;
        this.f7541b = predicate;
        this.f7542c = set2;
    }

    public final Iterator<E> iterator() {
        return Iterators.b(this.f7540a.iterator(), this.f7541b);
    }

    public final int size() {
        return Iterators.b(iterator());
    }

    public final boolean isEmpty() {
        return !iterator().hasNext();
    }

    public final boolean contains(Object obj) {
        return this.f7540a.contains(obj) && this.f7542c.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.f7540a.containsAll(collection) && this.f7542c.containsAll(collection);
    }
}
