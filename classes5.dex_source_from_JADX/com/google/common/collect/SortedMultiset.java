package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset.Entry;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible
@Beta
/* compiled from: calling listen(int) on FakeSocketImpl */
public interface SortedMultiset<E> extends SortedIterable<E>, SortedMultisetBridge<E> {
    SortedMultiset<E> mo895a(E e, BoundType boundType);

    SortedMultiset<E> mo896a(E e, BoundType boundType, E e2, BoundType boundType2);

    Set<Entry<E>> mo897a();

    SortedMultiset<E> mo898b(E e, BoundType boundType);

    Comparator<? super E> comparator();

    NavigableSet<E> mo903g();

    Entry<E> mo904h();

    Entry<E> mo905i();

    Entry<E> mo906j();

    Entry<E> mo907k();

    SortedMultiset<E> mo909n();
}
