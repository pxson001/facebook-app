package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: buy_tickets_cta */
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    final /* synthetic */ ImmutableCollection m13406a() {
        return m13405b();
    }

    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    private ImmutableSortedSet<E> m13405b() {
        return (ImmutableSortedSet) super.a();
    }

    public final Comparator<? super E> comparator() {
        return m13405b().comparator();
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public final int indexOf(@Nullable Object obj) {
        int a = m13405b().a(obj);
        return (a < 0 || !get(a).equals(obj)) ? -1 : a;
    }

    @GwtIncompatible("ImmutableSortedSet.indexOf")
    public final int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @GwtIncompatible("super.subListUnchecked does not exist; inherited subList is valid if slow")
    final ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(i, i2), comparator()).asList();
    }
}
