package com.facebook.common.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: xml_megaphone */
public final class Sets {
    private Sets() {
    }

    public static <E> HashSet<E> m32764a() {
        return new HashSet();
    }

    public static <E> HashSet<E> m32766a(E... eArr) {
        HashSet hashSet = new HashSet(eArr.length);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }

    public static <E> HashSet<E> m32765a(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new HashSet((Collection) iterable);
        }
        HashSet<E> a = m32764a();
        for (Object add : iterable) {
            a.add(add);
        }
        return a;
    }
}
