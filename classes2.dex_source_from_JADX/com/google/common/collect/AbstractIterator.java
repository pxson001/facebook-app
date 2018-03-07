package com.google.common.collect;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
/* compiled from: wlan0 */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
    public State f710a = State.NOT_READY;
    public T f711b;

    /* compiled from: wlan0 */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* compiled from: wlan0 */
    /* synthetic */ class C00491 {
        static final /* synthetic */ int[] f717a = new int[State.values().length];

        static {
            try {
                f717a[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f717a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public abstract T mo209a();

    protected AbstractIterator() {
    }

    protected final T m1437b() {
        this.f710a = State.DONE;
        return null;
    }

    public final boolean hasNext() {
        Preconditions.checkState(this.f710a != State.FAILED);
        switch (C00491.f717a[this.f710a.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return false;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return true;
            default:
                boolean z;
                this.f710a = State.FAILED;
                this.f711b = mo209a();
                if (this.f710a != State.DONE) {
                    this.f710a = State.READY;
                    z = true;
                } else {
                    z = false;
                }
                return z;
        }
    }

    public final T next() {
        if (hasNext()) {
            this.f710a = State.NOT_READY;
            T t = this.f711b;
            this.f711b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
