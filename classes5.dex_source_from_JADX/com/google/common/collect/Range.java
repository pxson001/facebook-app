package com.google.common.collect;

import android.support.v7.widget.LinearLayoutCompat;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Cut.AboveAll;
import com.google.common.collect.Cut.BelowAll;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bugreports */
public final class Range<C extends Comparable> implements Predicate<C>, Serializable {
    static final Ordering<Range<?>> f7528a = new RangeLexOrdering();
    public static final Function<Range, Cut> f7529b = new C08341();
    private static final Function<Range, Cut> f7530c = new C08352();
    public static final Range<Comparable> f7531d = new Range(BelowAll.f7295a, AboveAll.f7294a);
    public final Cut<C> lowerBound;
    public final Cut<C> upperBound;

    /* compiled from: bugreports */
    final class C08341 implements Function<Range, Cut> {
        C08341() {
        }

        public final Object apply(Object obj) {
            return ((Range) obj).lowerBound;
        }
    }

    /* compiled from: bugreports */
    final class C08352 implements Function<Range, Cut> {
        C08352() {
        }

        public final Object apply(Object obj) {
            return ((Range) obj).upperBound;
        }
    }

    /* compiled from: bugreports */
    /* synthetic */ class C08363 {
        static final /* synthetic */ int[] f7527a = new int[BoundType.values().length];

        static {
            try {
                f7527a[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7527a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: bugreports */
    class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        public int compare(Object obj, Object obj2) {
            Range range = (Range) obj;
            Range range2 = (Range) obj2;
            return ComparisonChain.a.a(range.lowerBound, range2.lowerBound).a(range.upperBound, range2.upperBound).b();
        }
    }

    @Deprecated
    public final boolean apply(Object obj) {
        return m13610a((Comparable) obj);
    }

    public static <C extends Comparable<?>> Range<C> m13602a(Cut<C> cut, Cut<C> cut2) {
        return new Range(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> m13605a(C c, C c2) {
        return m13602a(Cut.m13293b((Comparable) c), Cut.m13294c(c2));
    }

    public static <C extends Comparable<?>> Range<C> m13607b(C c, C c2) {
        return m13602a(Cut.m13293b((Comparable) c), Cut.m13293b((Comparable) c2));
    }

    public static <C extends Comparable<?>> Range<C> m13604a(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return m13602a(boundType == BoundType.OPEN ? Cut.m13294c(c) : Cut.m13293b((Comparable) c), boundType2 == BoundType.OPEN ? Cut.m13293b((Comparable) c2) : Cut.m13294c(c2));
    }

    public static <C extends Comparable<?>> Range<C> m13603a(C c, BoundType boundType) {
        switch (C08363.f7527a[boundType.ordinal()]) {
            case 1:
                return m13602a(BelowAll.f7295a, Cut.m13293b((Comparable) c));
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return m13602a(BelowAll.f7295a, Cut.m13294c(c));
            default:
                throw new AssertionError();
        }
    }

    public static <C extends Comparable<?>> Range<C> m13606b(C c, BoundType boundType) {
        switch (C08363.f7527a[boundType.ordinal()]) {
            case 1:
                return m13602a(Cut.m13294c(c), AboveAll.f7294a);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return m13602a(Cut.m13293b((Comparable) c), AboveAll.f7294a);
            default:
                throw new AssertionError();
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.mo914a((Cut) cut2) > 0 || cut == AboveAll.f7294a || cut2 == BelowAll.f7295a) {
            throw new IllegalArgumentException("Invalid range: " + m13608b((Cut) cut, (Cut) cut2));
        }
    }

    public final boolean m13613c() {
        return this.lowerBound != BelowAll.f7295a;
    }

    public final C m13614d() {
        return this.lowerBound.mo920c();
    }

    public final boolean m13615f() {
        return this.upperBound != AboveAll.f7294a;
    }

    public final C m13616g() {
        return this.upperBound.mo920c();
    }

    public final boolean m13617i() {
        return this.lowerBound.equals(this.upperBound);
    }

    public final boolean m13610a(C c) {
        Preconditions.checkNotNull(c);
        return this.lowerBound.mo917a((Comparable) c) && !this.upperBound.mo917a((Comparable) c);
    }

    public final boolean m13611b(Range<C> range) {
        return this.lowerBound.mo914a(range.upperBound) <= 0 && range.lowerBound.mo914a(this.upperBound) <= 0;
    }

    public final Range<C> m13612c(Range<C> range) {
        int a = this.lowerBound.mo914a(range.lowerBound);
        int a2 = this.upperBound.mo914a(range.upperBound);
        if (a >= 0 && a2 <= 0) {
            return this;
        }
        if (a <= 0 && a2 >= 0) {
            return range;
        }
        return m13602a(a >= 0 ? this.lowerBound : range.lowerBound, a2 <= 0 ? this.upperBound : range.upperBound);
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public final String toString() {
        return m13608b(this.lowerBound, this.upperBound);
    }

    private static String m13608b(Cut<?> cut, Cut<?> cut2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        cut.mo916a(stringBuilder);
        stringBuilder.append('‥');
        cut2.mo919b(stringBuilder);
        return stringBuilder.toString();
    }

    final Object readResolve() {
        if (equals(f7531d)) {
            return f7531d;
        }
        return this;
    }

    static int m13609c(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
