package com.facebook.common.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: worst_row_key */
public class ImmutableSet<E> extends HashSet<E> {
    private ImmutableSet(Set<E> set) {
        super(set);
    }

    public static <E> ImmutableSet<E> m32767a(Set<E> set) {
        return new ImmutableSet(set);
    }

    public static <E> ImmutableSet<E> m32768a(E... eArr) {
        Object hashSet = new HashSet();
        Collections.addAll(hashSet, eArr);
        return new ImmutableSet(hashSet);
    }
}
