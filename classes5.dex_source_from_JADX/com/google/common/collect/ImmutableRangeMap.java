package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists.KeyAbsentBehavior;
import com.google.common.collect.SortedLists.KeyPresentBehavior;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
@Beta
/* compiled from: bylines */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    public static final ImmutableRangeMap<Comparable<?>, Object> f7346a = new ImmutableRangeMap(RegularImmutableList.a, RegularImmutableList.a);
    private final transient ImmutableList<Range<K>> f7347b;
    private final transient ImmutableList<V> f7348c;

    /* compiled from: bylines */
    public final class Builder<K extends Comparable<?>, V> {
        private final RangeSet<K> f7344a = new TreeRangeSet(new TreeMap());
        private final RangeMap<K, V> f7345b = new TreeRangeMap();

        public final Builder<K, V> m13396a(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.m13617i(), "Range must not be empty, but was %s", new Object[]{range});
            if (!this.f7344a.mo1010b().mo1012c(range)) {
                for (Entry entry : this.f7345b.mo931b().entrySet()) {
                    Range range2 = (Range) entry.getKey();
                    if (range2.m13611b(range) && !range2.m13612c(range).m13617i()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range + " overlaps with entry " + entry);
                    }
                }
            }
            this.f7344a.mo894a(range);
            this.f7345b.mo930a(range, v);
            return this;
        }

        public final ImmutableRangeMap<K, V> m13397a() {
            Map b = this.f7345b.mo931b();
            com.google.common.collect.ImmutableList.Builder builder = new com.google.common.collect.ImmutableList.Builder(b.size());
            com.google.common.collect.ImmutableList.Builder builder2 = new com.google.common.collect.ImmutableList.Builder(b.size());
            for (Entry entry : b.entrySet()) {
                builder.c(entry.getKey());
                builder2.c(entry.getValue());
            }
            return new ImmutableRangeMap(builder.b(), builder2.b());
        }
    }

    /* compiled from: bylines */
    public class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        public final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.f7346a;
            }
            Builder builder = new Builder();
            UnmodifiableIterator it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                builder.m13396a((Range) entry.getKey(), entry.getValue());
            }
            return builder.m13397a();
        }
    }

    public final /* synthetic */ Map mo931b() {
        return m13400c();
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.f7347b = immutableList;
        this.f7348c = immutableList2;
    }

    @Nullable
    public final V m13401a(K k) {
        ImmutableList immutableList = this.f7347b;
        Function function = Range.f7529b;
        int a = SortedLists.m13659a(immutableList, function, Cut.m13293b((Comparable) k), NaturalOrdering.a, KeyPresentBehavior.ANY_PRESENT, KeyAbsentBehavior.NEXT_LOWER);
        if (a == -1) {
            return null;
        }
        return ((Range) this.f7347b.get(a)).m13610a(k) ? this.f7348c.get(a) : null;
    }

    public final void mo930a(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    private ImmutableMap<Range<K>, V> m13400c() {
        if (this.f7347b.isEmpty()) {
            return RegularImmutableBiMap.a;
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.f7347b, Range.f7528a), this.f7348c);
    }

    public int hashCode() {
        return m13400c().hashCode();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RangeMap)) {
            return false;
        }
        return m13400c().equals(((RangeMap) obj).mo931b());
    }

    public String toString() {
        return m13400c().toString();
    }

    Object writeReplace() {
        return new SerializedForm(m13400c());
    }
}
