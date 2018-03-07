package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
@Beta
/* compiled from: bug_report_id */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap f7602b = new C08601();
    public final NavigableMap<Cut<K>, RangeMapEntry<K, V>> f7603a = Maps.f();

    /* compiled from: bug_report_id */
    final class C08601 implements RangeMap {
        C08601() {
        }

        public final void mo930a(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public final Map<Range, Object> mo931b() {
            return Collections.emptyMap();
        }
    }

    /* compiled from: bug_report_id */
    final class AsMapOfRanges extends IteratorBasedAbstractMap<Range<K>, V> {
        final Iterable<Entry<Range<K>, V>> f7598a;
        final /* synthetic */ TreeRangeMap f7599b;

        AsMapOfRanges(TreeRangeMap treeRangeMap, Iterable<RangeMapEntry<K, V>> iterable) {
            this.f7599b = treeRangeMap;
            this.f7598a = iterable;
        }

        public final boolean containsKey(@Nullable Object obj) {
            return get(obj) != null;
        }

        public final V get(@Nullable Object obj) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                RangeMapEntry rangeMapEntry = (RangeMapEntry) this.f7599b.f7603a.get(range.lowerBound);
                if (rangeMapEntry != null && rangeMapEntry.f7600a.equals(range)) {
                    return rangeMapEntry.getValue();
                }
            }
            return null;
        }

        public final int size() {
            return this.f7599b.f7603a.size();
        }

        final Iterator<Entry<Range<K>, V>> m13751d() {
            return this.f7598a.iterator();
        }
    }

    /* compiled from: bug_report_id */
    public final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        public final Range<K> f7600a;
        private final V f7601b;

        RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.m13602a((Cut) cut, (Cut) cut2), v);
        }

        RangeMapEntry(Range<K> range, V v) {
            this.f7600a = range;
            this.f7601b = v;
        }

        public final /* synthetic */ Object getKey() {
            return this.f7600a;
        }

        public final V getValue() {
            return this.f7601b;
        }

        final Cut<K> m13752c() {
            return this.f7600a.upperBound;
        }
    }

    public final void mo930a(Range<K> range, V v) {
        if (!range.m13617i()) {
            Preconditions.checkNotNull(v);
            m13754a(range);
            this.f7603a.put(range.lowerBound, new RangeMapEntry(range, v));
        }
    }

    private void m13753a(Cut<K> cut, Cut<K> cut2, V v) {
        this.f7603a.put(cut, new RangeMapEntry(cut, cut2, v));
    }

    private void m13754a(Range<K> range) {
        if (!range.m13617i()) {
            RangeMapEntry rangeMapEntry;
            Entry lowerEntry = this.f7603a.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                rangeMapEntry = (RangeMapEntry) lowerEntry.getValue();
                if (rangeMapEntry.m13752c().mo914a(range.lowerBound) > 0) {
                    if (rangeMapEntry.m13752c().mo914a(range.upperBound) > 0) {
                        m13753a(range.upperBound, rangeMapEntry.m13752c(), ((RangeMapEntry) lowerEntry.getValue()).getValue());
                    }
                    m13753a(rangeMapEntry.f7600a.lowerBound, range.lowerBound, ((RangeMapEntry) lowerEntry.getValue()).getValue());
                }
            }
            Entry lowerEntry2 = this.f7603a.lowerEntry(range.upperBound);
            if (lowerEntry2 != null) {
                rangeMapEntry = (RangeMapEntry) lowerEntry2.getValue();
                if (rangeMapEntry.m13752c().mo914a(range.upperBound) > 0) {
                    m13753a(range.upperBound, rangeMapEntry.m13752c(), ((RangeMapEntry) lowerEntry2.getValue()).getValue());
                    this.f7603a.remove(range.lowerBound);
                }
            }
            this.f7603a.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    public final Map<Range<K>, V> mo931b() {
        return new AsMapOfRanges(this, this.f7603a.values());
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof RangeMap)) {
            return false;
        }
        return mo931b().equals(((RangeMap) obj).mo931b());
    }

    public final int hashCode() {
        return mo931b().hashCode();
    }

    public final String toString() {
        return this.f7603a.values().toString();
    }
}
