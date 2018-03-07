package com.facebook.common.collect;

import com.facebook.common.collect.MergeJoinIterator.KeyExtractor;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: story_identifier */
public class MergeJoinIteratorBuilder<LEFT, RIGHT, KEY> {
    private KeyExtractor<LEFT, KEY> f2510a;
    private KeyExtractor<RIGHT, KEY> f2511b;
    private Comparator<KEY> f2512c;
    private Iterator<LEFT> f2513d;
    private Iterator<RIGHT> f2514e;

    public final MergeJoinIteratorBuilder m3632a(KeyExtractor<RIGHT, KEY> keyExtractor) {
        this.f2511b = keyExtractor;
        return this;
    }

    public final MergeJoinIteratorBuilder m3635b(KeyExtractor<LEFT, KEY> keyExtractor) {
        this.f2510a = keyExtractor;
        return this;
    }

    public final MergeJoinIteratorBuilder m3633a(Comparator<KEY> comparator) {
        this.f2512c = comparator;
        return this;
    }

    public final MergeJoinIteratorBuilder m3634a(Iterator<LEFT> it) {
        this.f2513d = it;
        return this;
    }

    public final MergeJoinIteratorBuilder m3636b(Iterator<RIGHT> it) {
        this.f2514e = it;
        return this;
    }

    public final MergeJoinIterator m3631a() {
        return new MergeJoinIterator(this.f2512c, this.f2513d, this.f2514e, this.f2510a, this.f2511b);
    }
}
