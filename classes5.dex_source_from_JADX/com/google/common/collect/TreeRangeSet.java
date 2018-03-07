package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut.AboveAll;
import com.google.common.collect.Cut.BelowAll;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible("uses NavigableMap")
@Beta
/* compiled from: bug_report_failed_too_old */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> {
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> f7606a;
    private transient Set<Range<C>> f7607b;
    private transient RangeSet<C> f7608c;

    /* compiled from: bug_report_failed_too_old */
    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> f7604a;
        final /* synthetic */ TreeRangeSet f7605b;

        protected final /* synthetic */ Object m13758e() {
            return m13757b();
        }

        AsRanges(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f7605b = treeRangeSet;
            this.f7604a = collection;
        }

        protected final Collection<Range<C>> m13757b() {
            return this.f7604a;
        }

        public final int hashCode() {
            return Sets.a(this);
        }

        public final boolean equals(@Nullable Object obj) {
            return Sets.a(this, obj);
        }
    }

    /* compiled from: bug_report_failed_too_old */
    final class Complement extends TreeRangeSet<C> {
        final /* synthetic */ TreeRangeSet f7609b;

        Complement(TreeRangeSet treeRangeSet) {
            this.f7609b = treeRangeSet;
            super(new ComplementRangesByLowerBound(treeRangeSet.f7606a));
        }

        public final void mo894a(Range<C> range) {
            this.f7609b.mo1011b(range);
        }

        public final void mo1011b(Range<C> range) {
            this.f7609b.mo894a(range);
        }

        public final RangeSet<C> mo1010b() {
            return this.f7609b;
        }
    }

    /* compiled from: bug_report_failed_too_old */
    final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> f7618a;
        private final NavigableMap<Cut<C>, Range<C>> f7619b;
        public final Range<Cut<C>> f7620c;

        public final Comparator<? super Cut<C>> comparator() {
            return NaturalOrdering.a;
        }

        ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.f7531d);
        }

        @Nullable
        public final /* synthetic */ Object get(Object obj) {
            return m13770a(obj);
        }

        public final NavigableMap headMap(Object obj, boolean z) {
            return m13771a(Range.m13603a((Cut) obj, BoundType.forBoolean(z)));
        }

        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return m13771a(Range.m13604a((Cut) obj, BoundType.forBoolean(z), (Cut) obj2, BoundType.forBoolean(z2)));
        }

        public final /* synthetic */ NavigableMap tailMap(Object obj, boolean z) {
            return m13772b((Cut) obj, z);
        }

        private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f7618a = navigableMap;
            this.f7619b = new RangesByUpperBound(navigableMap);
            this.f7620c = range;
        }

        private NavigableMap<Cut<C>, Range<C>> m13771a(Range<Cut<C>> range) {
            if (!this.f7620c.m13611b(range)) {
                return ImmutableSortedMap.b;
            }
            return new ComplementRangesByLowerBound(this.f7618a, range.m13612c(this.f7620c));
        }

        private NavigableMap<Cut<C>, Range<C>> m13772b(Cut<C> cut, boolean z) {
            return m13771a(Range.m13606b((Comparable) cut, BoundType.forBoolean(z)));
        }

        final Iterator<Entry<Cut<C>, Range<C>>> m13774d() {
            Collection values;
            Cut cut;
            if (this.f7620c.m13613c()) {
                boolean z;
                NavigableMap navigableMap = this.f7619b;
                Comparable d = this.f7620c.m13614d();
                if (this.f7620c.lowerBound.mo915a() == BoundType.CLOSED) {
                    z = true;
                } else {
                    z = false;
                }
                values = navigableMap.tailMap(d, z).values();
            } else {
                values = this.f7619b.values();
            }
            final PeekingIterator i = Iterators.i(values.iterator());
            if (this.f7620c.m13610a(BelowAll.f7295a) && (!i.hasNext() || ((Range) i.mo932a()).lowerBound != BelowAll.f7295a)) {
                cut = BelowAll.f7295a;
            } else if (!i.hasNext()) {
                return Iterators.a;
            } else {
                cut = ((Range) i.next()).upperBound;
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>(this) {
                Cut<C> f7610a = cut;
                final /* synthetic */ ComplementRangesByLowerBound f7613d;

                protected final Object m13768a() {
                    if (this.f7613d.f7620c.upperBound.mo917a(this.f7610a) || this.f7610a == AboveAll.f7294a) {
                        return (Entry) b();
                    }
                    Range range;
                    if (i.hasNext()) {
                        range = (Range) i.next();
                        Range a = Range.m13602a(this.f7610a, range.lowerBound);
                        this.f7610a = range.upperBound;
                        range = a;
                    } else {
                        range = Range.m13602a(this.f7610a, AboveAll.f7294a);
                        this.f7610a = AboveAll.f7294a;
                    }
                    return Maps.a(range.lowerBound, range);
                }
            };
        }

        final Iterator<Entry<Cut<C>, Range<C>>> mo965a() {
            Object obj;
            boolean z;
            Cut cut;
            if (this.f7620c.m13615f()) {
                obj = (Cut) this.f7620c.m13616g();
            } else {
                obj = AboveAll.f7294a;
            }
            if (this.f7620c.m13615f() && this.f7620c.upperBound.mo918b() == BoundType.CLOSED) {
                z = true;
            } else {
                z = false;
            }
            final PeekingIterator i = Iterators.i(this.f7619b.headMap(obj, z).descendingMap().values().iterator());
            if (i.hasNext()) {
                if (((Range) i.mo932a()).upperBound == AboveAll.f7294a) {
                    obj = ((Range) i.next()).lowerBound;
                } else {
                    cut = (Cut) this.f7618a.higherKey(((Range) i.mo932a()).upperBound);
                }
            } else if (!this.f7620c.m13610a(BelowAll.f7295a) || this.f7618a.containsKey(BelowAll.f7295a)) {
                return Iterators.a;
            } else {
                cut = (Cut) this.f7618a.higherKey(BelowAll.f7295a);
            }
            cut = (Cut) MoreObjects.firstNonNull(obj, AboveAll.f7294a);
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>(this) {
                Cut<C> f7614a = cut;
                final /* synthetic */ ComplementRangesByLowerBound f7617d;

                protected final Object m13769a() {
                    if (this.f7614a == BelowAll.f7295a) {
                        return (Entry) b();
                    }
                    Range range;
                    if (i.hasNext()) {
                        range = (Range) i.next();
                        Range a = Range.m13602a(range.upperBound, this.f7614a);
                        this.f7614a = range.lowerBound;
                        if (this.f7617d.f7620c.lowerBound.mo917a(a.lowerBound)) {
                            return Maps.a(a.lowerBound, a);
                        }
                    } else if (this.f7617d.f7620c.lowerBound.mo917a(BelowAll.f7295a)) {
                        range = Range.m13602a(BelowAll.f7295a, this.f7614a);
                        this.f7614a = BelowAll.f7295a;
                        return Maps.a(BelowAll.f7295a, range);
                    }
                    return (Entry) b();
                }
            };
        }

        public final int size() {
            return Iterators.b(m13774d());
        }

        @Nullable
        private Range<C> m13770a(Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    Entry firstEntry = m13772b(cut, true).firstEntry();
                    if (firstEntry != null && ((Cut) firstEntry.getKey()).equals(cut)) {
                        return (Range) firstEntry.getValue();
                    }
                } catch (ClassCastException e) {
                    return null;
                }
            }
            return null;
        }

        public final boolean containsKey(Object obj) {
            return m13770a(obj) != null;
        }
    }

    @VisibleForTesting
    /* compiled from: bug_report_failed_too_old */
    final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> f7625a;
        public final Range<Cut<C>> f7626b;

        public final Comparator<? super Cut<C>> comparator() {
            return NaturalOrdering.a;
        }

        public final /* synthetic */ Object get(@Nullable Object obj) {
            return m13777a(obj);
        }

        public final NavigableMap headMap(Object obj, boolean z) {
            return m13778a(Range.m13603a((Cut) obj, BoundType.forBoolean(z)));
        }

        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return m13778a(Range.m13604a((Cut) obj, BoundType.forBoolean(z), (Cut) obj2, BoundType.forBoolean(z2)));
        }

        public final NavigableMap tailMap(Object obj, boolean z) {
            return m13778a(Range.m13606b((Cut) obj, BoundType.forBoolean(z)));
        }

        RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f7625a = navigableMap;
            this.f7626b = Range.f7531d;
        }

        private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f7625a = navigableMap;
            this.f7626b = range;
        }

        private NavigableMap<Cut<C>, Range<C>> m13778a(Range<Cut<C>> range) {
            if (range.m13611b(this.f7626b)) {
                return new RangesByUpperBound(this.f7625a, range.m13612c(this.f7626b));
            }
            return ImmutableSortedMap.b;
        }

        public final boolean containsKey(@Nullable Object obj) {
            return m13777a(obj) != null;
        }

        private Range<C> m13777a(@Nullable Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (!this.f7626b.m13610a(cut)) {
                        return null;
                    }
                    Entry lowerEntry = this.f7625a.lowerEntry(cut);
                    if (lowerEntry != null && ((Range) lowerEntry.getValue()).upperBound.equals(cut)) {
                        return (Range) lowerEntry.getValue();
                    }
                } catch (ClassCastException e) {
                    return null;
                }
            }
            return null;
        }

        final Iterator<Entry<Cut<C>, Range<C>>> m13780d() {
            Iterator it;
            if (this.f7626b.m13613c()) {
                Entry lowerEntry = this.f7625a.lowerEntry(this.f7626b.m13614d());
                if (lowerEntry == null) {
                    it = this.f7625a.values().iterator();
                } else if (this.f7626b.lowerBound.mo917a(((Range) lowerEntry.getValue()).upperBound)) {
                    it = this.f7625a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f7625a.tailMap(this.f7626b.m13614d(), true).values().iterator();
                }
            } else {
                it = this.f7625a.values().iterator();
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>(this) {
                final /* synthetic */ RangesByUpperBound f7622b;

                protected final Object m13775a() {
                    if (!it.hasNext()) {
                        return (Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (this.f7622b.f7626b.upperBound.mo917a(range.upperBound)) {
                        return (Entry) b();
                    }
                    return Maps.a(range.upperBound, range);
                }
            };
        }

        final Iterator<Entry<Cut<C>, Range<C>>> mo965a() {
            Collection values;
            if (this.f7626b.m13615f()) {
                values = this.f7625a.headMap(this.f7626b.m13616g(), false).descendingMap().values();
            } else {
                values = this.f7625a.descendingMap().values();
            }
            final PeekingIterator i = Iterators.i(values.iterator());
            if (i.hasNext() && this.f7626b.upperBound.mo917a(((Range) i.mo932a()).upperBound)) {
                i.next();
            }
            return new AbstractIterator<Entry<Cut<C>, Range<C>>>(this) {
                final /* synthetic */ RangesByUpperBound f7624b;

                protected final Object m13776a() {
                    if (!i.hasNext()) {
                        return (Entry) b();
                    }
                    Range range = (Range) i.next();
                    if (this.f7624b.f7626b.lowerBound.mo917a(range.upperBound)) {
                        return Maps.a(range.upperBound, range);
                    }
                    return (Entry) b();
                }
            };
        }

        public final int size() {
            if (this.f7626b.equals(Range.f7531d)) {
                return this.f7625a.size();
            }
            return Iterators.b(m13780d());
        }

        public final boolean isEmpty() {
            if (this.f7626b.equals(Range.f7531d)) {
                return this.f7625a.isEmpty();
            }
            return !m13780d().hasNext();
        }
    }

    public TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.f7606a = navigableMap;
    }

    public final Set<Range<C>> mo1009a() {
        Set<Range<C>> set = this.f7607b;
        if (set != null) {
            return set;
        }
        set = new AsRanges(this, this.f7606a.values());
        this.f7607b = set;
        return set;
    }

    public final boolean mo1012c(Range<C> range) {
        Preconditions.checkNotNull(range);
        Entry floorEntry = this.f7606a.floorEntry(range.lowerBound);
        if (floorEntry != null) {
            Range range2 = (Range) floorEntry.getValue();
            Object obj = (range2.lowerBound.mo914a(range.lowerBound) > 0 || range2.upperBound.mo914a(range.upperBound) < 0) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public void mo894a(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (!range.m13617i()) {
            Range range2;
            Cut cut = range.lowerBound;
            Cut cut2 = range.upperBound;
            Entry lowerEntry = this.f7606a.lowerEntry(cut);
            if (lowerEntry != null) {
                range2 = (Range) lowerEntry.getValue();
                if (range2.upperBound.mo914a(cut) >= 0) {
                    if (range2.upperBound.mo914a(cut2) >= 0) {
                        cut2 = range2.upperBound;
                    }
                    cut = range2.lowerBound;
                }
            }
            lowerEntry = this.f7606a.floorEntry(cut2);
            if (lowerEntry != null) {
                range2 = (Range) lowerEntry.getValue();
                if (range2.upperBound.mo914a(cut2) >= 0) {
                    cut2 = range2.upperBound;
                }
            }
            this.f7606a.subMap(cut, cut2).clear();
            m13759d(Range.m13602a(cut, cut2));
        }
    }

    public void mo1011b(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (!range.m13617i()) {
            Range range2;
            Entry lowerEntry = this.f7606a.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                range2 = (Range) lowerEntry.getValue();
                if (range2.upperBound.mo914a(range.lowerBound) >= 0) {
                    if (range.m13615f() && range2.upperBound.mo914a(range.upperBound) >= 0) {
                        m13759d(Range.m13602a(range.upperBound, range2.upperBound));
                    }
                    m13759d(Range.m13602a(range2.lowerBound, range.lowerBound));
                }
            }
            lowerEntry = this.f7606a.floorEntry(range.upperBound);
            if (lowerEntry != null) {
                range2 = (Range) lowerEntry.getValue();
                if (range.m13615f() && range2.upperBound.mo914a(range.upperBound) >= 0) {
                    m13759d(Range.m13602a(range.upperBound, range2.upperBound));
                }
            }
            this.f7606a.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    private void m13759d(Range<C> range) {
        if (range.m13617i()) {
            this.f7606a.remove(range.lowerBound);
        } else {
            this.f7606a.put(range.lowerBound, range);
        }
    }

    public RangeSet<C> mo1010b() {
        RangeSet<C> rangeSet = this.f7608c;
        if (rangeSet != null) {
            return rangeSet;
        }
        rangeSet = new Complement(this);
        this.f7608c = rangeSet;
        return rangeSet;
    }
}
