package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
/* compiled from: zero_token_fetch_failed */
public final class CollectPreconditions {
    CollectPreconditions() {
    }

    static void m616a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    public static int m615a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    static void m617a(boolean z) {
        Preconditions.checkState(z, "no calls to next() since the last call to remove()");
    }
}
