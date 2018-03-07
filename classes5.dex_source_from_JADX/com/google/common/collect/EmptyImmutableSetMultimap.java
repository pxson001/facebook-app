package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* compiled from: call_to_action */
public class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    public static final EmptyImmutableSetMultimap f7298a = new EmptyImmutableSetMultimap();

    private Object readResolve() {
        return f7298a;
    }

    private EmptyImmutableSetMultimap() {
        super(RegularImmutableBiMap.a, 0, null);
    }
}
