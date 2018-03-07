package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: callerContext */
public class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    public static final EmptyImmutableListMultimap f7297a = new EmptyImmutableListMultimap();

    private Object readResolve() {
        return f7297a;
    }

    private EmptyImmutableListMultimap() {
        super(RegularImmutableBiMap.a, 0);
    }
}
