package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible
/* compiled from: written_while_video_was_live */
public abstract class AbstractIterator<T> implements Iterator<T> {
    public T next;
    public State state = State.NOT_READY;

    /* compiled from: written_while_video_was_live */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T computeNext();

    protected AbstractIterator() {
    }

    public final boolean hasNext() {
        Preconditions.checkState(this.state != State.FAILED);
        switch (this.state) {
            case READY:
                return true;
            case DONE:
                return false;
            default:
                boolean z;
                this.state = State.FAILED;
                this.next = computeNext();
                if (this.state != State.DONE) {
                    this.state = State.READY;
                    z = true;
                } else {
                    z = false;
                }
                return z;
        }
    }

    public final T next() {
        if (hasNext()) {
            this.state = State.NOT_READY;
            T t = this.next;
            this.next = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
