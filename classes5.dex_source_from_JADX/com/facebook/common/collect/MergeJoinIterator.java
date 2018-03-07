package com.facebook.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: story_like */
public class MergeJoinIterator<LEFT, RIGHT, KEY> extends AbstractIterator<Entry<LEFT, RIGHT>> {
    public final Comparator<KEY> f2503a;
    private final PeekingIterator<LEFT> f2504b;
    private final PeekingIterator<RIGHT> f2505c;
    private final KeyExtractor<LEFT, KEY> f2506d;
    private final KeyExtractor<RIGHT, KEY> f2507e;
    public KEY f2508f;
    private KEY f2509g;

    @Immutable
    /* compiled from: story_like */
    public class Entry<LEFT, RIGHT> {
        public final LEFT f2501a;
        public final RIGHT f2502b;

        Entry(@Nullable LEFT left, @Nullable RIGHT right) {
            this.f2501a = left;
            this.f2502b = right;
        }
    }

    protected final Object m3630a() {
        if (!this.f2504b.hasNext() && !this.f2505c.hasNext()) {
            return (Entry) b();
        }
        Object a;
        Object a2;
        if (this.f2504b.hasNext()) {
            a = this.f2506d.a(this.f2504b.mo932a());
            if (this.f2508f != null) {
                Preconditions.checkState(this.f2503a.compare(a, this.f2508f) > 0, "Left iterator keys must be strictly ascending. (%s %s)", new Object[]{this.f2508f, a});
            }
        } else {
            a = null;
        }
        if (this.f2505c.hasNext()) {
            a2 = this.f2507e.a(this.f2505c.mo932a());
            m3629a(a2);
        } else {
            a2 = null;
        }
        if (!this.f2504b.hasNext() && this.f2505c.hasNext()) {
            return m3628a(null, this.f2505c.next());
        }
        if (this.f2504b.hasNext() && !this.f2505c.hasNext()) {
            return m3628a(this.f2504b.next(), null);
        }
        int compare = this.f2503a.compare(a, a2);
        if (compare > 0) {
            this.f2509g = a2;
            return m3628a(null, this.f2505c.next());
        } else if (compare < 0) {
            this.f2508f = a;
            return m3628a(this.f2504b.next(), null);
        } else {
            this.f2509g = a2;
            this.f2508f = a;
            return m3628a(this.f2504b.next(), this.f2505c.next());
        }
    }

    public MergeJoinIterator(Comparator<KEY> comparator, Iterator<LEFT> it, Iterator<RIGHT> it2, KeyExtractor<LEFT, KEY> keyExtractor, KeyExtractor<RIGHT, KEY> keyExtractor2) {
        this.f2503a = comparator;
        this.f2504b = Iterators.i(it);
        this.f2505c = Iterators.i(it2);
        this.f2506d = keyExtractor;
        this.f2507e = keyExtractor2;
    }

    private final void m3629a(KEY key) {
        if (this.f2509g != null) {
            Preconditions.checkState(this.f2503a.compare(key, this.f2509g) > 0, "Right iterator keys must be strictly ascending. (%s %s)", new Object[]{this.f2508f, key});
        }
    }

    private static Entry<LEFT, RIGHT> m3628a(@Nullable LEFT left, @Nullable RIGHT right) {
        return new Entry(left, right);
    }

    public static <LEFT, RIGHT, KEY> MergeJoinIteratorBuilder<LEFT, RIGHT, KEY> newBuilder() {
        return new MergeJoinIteratorBuilder();
    }
}
