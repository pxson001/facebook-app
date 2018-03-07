package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
/* compiled from: with_actor_profile_video_playback */
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private final int f720a;
    private int f721b;

    protected abstract E mo210a(int i);

    protected AbstractIndexedListIterator(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.f720a = i;
        this.f721b = i2;
    }

    public final boolean hasNext() {
        return this.f721b < this.f720a;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f721b;
            this.f721b = i + 1;
            return mo210a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f721b;
    }

    public final boolean hasPrevious() {
        return this.f721b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f721b - 1;
            this.f721b = i;
            return mo210a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f721b - 1;
    }
}
