package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: zero_debug_http_filter */
public abstract class ForwardingObject {
    protected abstract Object mo105e();

    protected ForwardingObject() {
    }

    public String toString() {
        return mo105e().toString();
    }
}
