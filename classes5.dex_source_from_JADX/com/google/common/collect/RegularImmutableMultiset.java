package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet.Indexed;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bugreporter */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static final RegularImmutableMultiset<Object> f7532a = new RegularImmutableMultiset(RegularImmutableList.a);
    public final transient Multisets$ImmutableEntry<E>[] f7533b;
    private final transient Multisets$ImmutableEntry<E>[] f7534c;
    private final transient int f7535d;
    private final transient int f7536e;
    private transient ImmutableSet<E> f7537f;

    /* compiled from: bugreporter */
    final class ElementSet extends Indexed<E> {
        final E m13621a(int i) {
            return RegularImmutableMultiset.this.f7533b[i].mo889a();
        }

        public final boolean contains(@Nullable Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        final boolean isPartialView() {
            return true;
        }

        public final int size() {
            return RegularImmutableMultiset.this.f7533b.length;
        }
    }

    /* compiled from: bugreporter */
    final class NonTerminalEntry<E> extends Multisets$ImmutableEntry<E> {
        private final Multisets$ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E e, int i, Multisets$ImmutableEntry<E> multisets$ImmutableEntry) {
            super(e, i);
            this.nextInBucket = multisets$ImmutableEntry;
        }

        public final Multisets$ImmutableEntry<E> mo981c() {
            return this.nextInBucket;
        }
    }

    public RegularImmutableMultiset(Collection<? extends Entry<? extends E>> collection) {
        int size = collection.size();
        Multisets$ImmutableEntry[] multisets$ImmutableEntryArr = new Multisets$ImmutableEntry[size];
        if (size == 0) {
            this.f7533b = multisets$ImmutableEntryArr;
            this.f7534c = null;
            this.f7535d = 0;
            this.f7536e = 0;
            this.f7537f = ImmutableSet.of();
            return;
        }
        size = Hashing.a(size, 1.0d);
        int i = size - 1;
        Multisets$ImmutableEntry[] multisets$ImmutableEntryArr2 = new Multisets$ImmutableEntry[size];
        Iterator it = collection.iterator();
        int i2 = 0;
        long j = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Multisets$ImmutableEntry multisets$ImmutableEntry;
            Multisets$AbstractEntry multisets$AbstractEntry = (Multisets$AbstractEntry) it.next();
            Object checkNotNull = Preconditions.checkNotNull(multisets$AbstractEntry.mo889a());
            int b = multisets$AbstractEntry.mo890b();
            int hashCode = checkNotNull.hashCode();
            int a = Hashing.a(hashCode) & i;
            Multisets$ImmutableEntry multisets$ImmutableEntry2 = multisets$ImmutableEntryArr2[a];
            if (multisets$ImmutableEntry2 == null) {
                Object obj = (!(multisets$AbstractEntry instanceof Multisets$ImmutableEntry) || (multisets$AbstractEntry instanceof NonTerminalEntry)) ? null : 1;
                multisets$ImmutableEntry = obj != null ? (Multisets$ImmutableEntry) multisets$AbstractEntry : new Multisets$ImmutableEntry(checkNotNull, b);
            } else {
                multisets$ImmutableEntry = new NonTerminalEntry(checkNotNull, b, multisets$ImmutableEntry2);
            }
            int i4 = (hashCode ^ b) + i3;
            int i5 = i2 + 1;
            multisets$ImmutableEntryArr[i2] = multisets$ImmutableEntry;
            multisets$ImmutableEntryArr2[a] = multisets$ImmutableEntry;
            j = ((long) b) + j;
            i2 = i5;
            i3 = i4;
        }
        this.f7533b = multisets$ImmutableEntryArr;
        this.f7534c = multisets$ImmutableEntryArr2;
        this.f7535d = Ints.b(j);
        this.f7536e = i3;
    }

    boolean isPartialView() {
        return false;
    }

    public final int m13623a(@Nullable Object obj) {
        Multisets$ImmutableEntry[] multisets$ImmutableEntryArr = this.f7534c;
        if (obj == null || multisets$ImmutableEntryArr == null) {
            return 0;
        }
        for (Multisets$ImmutableEntry multisets$ImmutableEntry = multisets$ImmutableEntryArr[Hashing.a(obj) & (multisets$ImmutableEntryArr.length - 1)]; multisets$ImmutableEntry != null; multisets$ImmutableEntry = multisets$ImmutableEntry.mo981c()) {
            if (Objects.equal(obj, multisets$ImmutableEntry.mo889a())) {
                return multisets$ImmutableEntry.mo890b();
            }
        }
        return 0;
    }

    public int size() {
        return this.f7535d;
    }

    public final Set m13625d() {
        Set set = this.f7537f;
        if (set != null) {
            return set;
        }
        ElementSet elementSet = new ElementSet();
        this.f7537f = elementSet;
        return elementSet;
    }

    final Entry<E> mo928a(int i) {
        return this.f7533b[i];
    }

    public int hashCode() {
        return this.f7536e;
    }
}
