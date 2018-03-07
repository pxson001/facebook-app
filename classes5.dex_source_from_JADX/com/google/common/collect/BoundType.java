package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: calling create() on FakeSocketImpl */
public enum BoundType {
    OPEN {
        final BoundType flip() {
            return BoundType.CLOSED;
        }
    },
    CLOSED {
        final BoundType flip() {
            return BoundType.OPEN;
        }
    };

    abstract BoundType flip();

    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
